/**
 * BeehiveZ is a business process model and instance management system.
 * Copyright (C) 2011  
 * Institute of Information System and Engineering, School of Software, Tsinghua University,
 * Beijing, China
 *
 * Contact: jintao05@gmail.com 
 *
 * This program is a free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation with the version of 2.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package cn.edu.thss.iise.beehivez.server.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

import org.processmining.framework.models.ModelGraphVertex;
import org.processmining.framework.models.fsm.FSMTransition;
import org.processmining.framework.models.petrinet.Marking;
import org.processmining.framework.models.petrinet.PetriNet;
import org.processmining.framework.models.petrinet.Place;
import org.processmining.framework.models.petrinet.State;
import org.processmining.framework.models.petrinet.StateSpace;
import org.processmining.framework.models.petrinet.Token;
import org.processmining.framework.models.petrinet.Transition;
import org.processmining.framework.models.petrinet.algorithms.CoverabilityGraphBuilder;

import att.grappa.Edge;

/**
 * clean models according to the requirements
 * 
 * @author Tao Jin
 * 
 */
public class CleanModels {

	/**
	 * @param path
	 *            where the models exist
	 * @param recordFileName
	 *            record the file need to be removed in this file
	 */
	public static void findModelsShouldBeRemoved(String path,
			String recordFileName) {
		try {
			FileWriter fw = new FileWriter(recordFileName, false);
			BufferedWriter bw = new BufferedWriter(fw);

			int nRemoveModels = 0;

			File dir = new File(path);
			for (File f : dir.listFiles()) {
				System.out.println("parsing " + f.getName());
				PetriNet pn = PetriNetUtil
						.getPetriNetFromPnml(new FileInputStream(f));

				for (Place place : pn.getPlaces()) {
					place.removeAllTokens();
					if (place.inDegree() == 0) {
						place.addToken(new Token());
					}
				}

				if (build(pn) == null) {
					bw.write(f.getName());
					bw.newLine();
					nRemoveModels++;
				}
			}
			System.out.println(nRemoveModels + " models should be removed");

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeFiles(String path, String listFileName) {
		try {
			FileReader fr = new FileReader(listFileName);
			BufferedReader br = new BufferedReader(fr);
			HashSet<String> fileList = new HashSet<String>();
			String fileName = br.readLine();
			while (fileName != null) {
				fileList.add(fileName);
				fileName = br.readLine();
			}

			int nFileRemoved = 0;
			int nFileTotal = 0;
			File dir = new File(path);
			for (File file : dir.listFiles()) {
				nFileTotal++;
				if (fileList.contains(file.getName())) {
					file.delete();
					nFileRemoved++;
				}
			}
			int nFileRemain = nFileTotal - nFileRemoved;

			System.out.println("the total number of files: " + nFileTotal);
			System.out.println("the number of files removed: " + nFileRemoved);
			System.out.println("the number of files remained: " + nFileRemain);

			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructs the full coverability graph for a given marked net. If a
	 * partial state space shall be constructed only, use
	 * {@link #build(PetriNet, int)} instead. <br>
	 * Remembers the start state (that is, the marking of the given net) in the
	 * {@link StateSpace#initialState initialState} attribute.
	 * 
	 * @param net
	 *            The marked net
	 * @return The coverability graph
	 */
	public synchronized static StateSpace build(PetriNet net) {
		// per default the full state space is constructed
		return build(net, -1);
	}

	/**
	 * Constructs the coverability graph with a potentially limited depth for a
	 * given marked net. If the full state space shall be constructed, use
	 * {@link #build(PetriNet)} instead. <br>
	 * Remembers the start state (that is, the marking of the given net) in the
	 * {@link StateSpace#initialState initialState} attribute.
	 * 
	 * @param net
	 *            The marked net
	 * @param depth
	 *            The depth until which the state space should be constructed.
	 *            If it is 0, only the initial state will be contained in the
	 *            constructed state space. If it is 1, the initial state and all
	 *            its direct successor states are constructed. If it is 2, all
	 *            direct successor states of the previously constructed states
	 *            are built as well etc.
	 * @return The coverability graph
	 */
	public synchronized static StateSpace build(PetriNet net, int depth) {
		return build(net, depth, false, true);
	}

	/**
	 * Construct a coverability graph.
	 * 
	 * @param net
	 *            The net to construct a (fragment) coverability graph for.
	 * @param depth
	 *            The maximal depth for the fragment.
	 * @param useAllPredecessors
	 *            Whether to use all predecessors when checking for unbounded
	 *            places or only spanning tree predecessors.
	 * @param expandUnboundedStates
	 *            Whether to expand unbounded states.
	 * @return A (fragment of) a coverability graph.
	 */
	public synchronized static StateSpace build(PetriNet net, int depth,
			boolean useAllPredecessors, boolean expandUnboundedStates) {
		// The assumption here is that this is a marked PetriNet
		long startTime = System.currentTimeMillis();

		Transition transition;
		Place place;
		Iterator it, pit;
		Marking marking, newMarking;
		State state, newState;
		StateSpace graph; // The graph constructed.
		Hashtable preSet; // For every transition its preset as a Marking.
		Hashtable postSet; // Idem, postset.
		LinkedList toDo; // States to expand.
		TreeMap treeMap; // Known marking and the corresponding states.
		ArrayList transitions; // Set of transitions.
		// / Association of toDo states with distance of their own depth level
		// to the
		// / specified maximum depth to be explored
		HashMap<State, Integer> depthLevel;
		Marking sinkMarking = new Marking();

		// Construct the presets and the postsets.
		preSet = new Hashtable();
		postSet = new Hashtable();
		it = net.getTransitions().iterator();
		while (it.hasNext()) {
			transition = (Transition) it.next();
			marking = new Marking();
			pit = transition.getPredecessors().iterator();
			while (pit.hasNext()) {
				place = (Place) pit.next();
				marking.addPlace(place, net.getEdgesBetween(place, transition)
						.size());
			}
			preSet.put(transition, marking);
			marking = new Marking();
			pit = transition.getSuccessors().iterator();
			while (pit.hasNext()) {
				place = (Place) pit.next();
				marking.addPlace(place, net.getEdgesBetween(transition, place)
						.size());
			}
			postSet.put(transition, marking);
		}

		ModelGraphVertex sink = net.getSink();
		if (sink instanceof Place) {
			sinkMarking.addPlace((Place) sink, 1);
		}

		// Construct the (empty) graph and the initial state
		graph = new StateSpace(net);
		state = new State(graph);
		marking = state.getMarking();
		it = net.getPlaces().iterator();
		while (it.hasNext()) {
			place = (Place) it.next();
			if (place.getNumberOfTokens() > 0) {
				marking.addPlace(place, place.getNumberOfTokens());
			}
		}
		graph.addState(state);
		// remember the start state, e.g., for potential traversals
		// HV graph.initialState = state;
		graph.setStartState(state);
		if (marking.equals(sinkMarking)) {
			graph.addAcceptState(state);
		}

		// Construct the stack of states to extend.
		toDo = new LinkedList();
		toDo.addLast(state);

		// / record depth for states if limited depth was requested
		depthLevel = new HashMap<State, Integer>();
		if (depth >= 0) {
			// / start state has distance 'depth' from given depth limit
			// / start state itself resides on depth level 0
			depthLevel.put(state, new Integer(depth));
		}

		// Construct a search tree for all markings in the graph.
		treeMap = new TreeMap();
		treeMap.put(marking, state);

		// Get these in adavnce, just in case this takes time computing over and
		// over again.
		transitions = net.getTransitions();

		// / temp variable to examine the distance from maximum depth for
		// current toDo state
		Integer currentDistObject;
		int currentDistance = 0;

		// Expand states.
		while (!toDo.isEmpty()) {// && (getAvailableMemory() > 0)) { // As long
			// as
			// there is a
			// state to
			// expand and
			// memory left
			long consumedTime = System.currentTimeMillis() - startTime;
			if (consumedTime > 1000) {
				return null;
			}

			state = (State) toDo.removeFirst(); // Take the first
			// (breadth-first)

			// / determine distance from maximum depth for current state
			// / (can be null if no depth limitation was specified by the user)
			currentDistObject = depthLevel.get(state);
			if (currentDistObject != null) {
				currentDistance = currentDistObject.intValue();
			}
			// / continue expanding sub levels only if:
			// / (a) no positive depth was specified (full coverability graph
			// will be constructed)
			// / (b) if depth limit was not reached yet (i.e., distance is
			// greater than 0)
			if (depth < 0 || currentDistance > 0) {
				marking = state.getMarking();

				// // don't test every transition, just test the possibly
				// enabled
				// // transition
				// HashSet<Transition> possibleEnabledTransitions = new
				// HashSet<Transition>();
				// Iterator itPlace = marking.iterator();
				// while (itPlace.hasNext()) {
				// Place p = (Place) itPlace.next();
				// possibleEnabledTransitions.addAll(p.getSuccessors());
				// }
				// it = possibleEnabledTransitions.iterator();

				it = transitions.iterator();
				while (it.hasNext()) { // For every transition
					transition = (Transition) it.next();
					if (((Marking) preSet.get(transition))
							.isLessOrEqual(marking)) { // If the transition is
						// enabled
						boolean isFresh = true;
						// Construct new marking after transition has fired
						newState = new State(graph);
						newMarking = newState.getMarking();
						newMarking.add(marking);
						newMarking.sub((Marking) preSet.get(transition));
						newMarking.add((Marking) postSet.get(transition));
						if (treeMap.containsKey(newMarking)) { // If the
							// marking is
							// already
							// present
							newState = (State) treeMap.get(newMarking);
							isFresh = false;
						} else { // If the marking is not present yet
							// Check all predecessors for token generators
							boolean isExtended = false;
							if (useAllPredecessors) {
								/**
								 * Check *all* predecessors, not only the ones
								 * according to the spanning tree of the graph.
								 */
								/**
								 * Set of predecessors seen.
								 */
								HashSet<State> predecessors = new HashSet<State>();
								/**
								 * Set of predecessors still to check for more
								 * predecessors.
								 */
								LinkedList<State> predecessorsToDo = new LinkedList<State>();
								/**
								 * Initialize both with the current state.
								 */
								predecessors.add(state);
								predecessorsToDo.addFirst(state);
								/**
								 * As long as there is a predecessor left to
								 * check: check it.
								 */
								while (!predecessorsToDo.isEmpty()) {
									State predecessor = predecessorsToDo
											.removeFirst();
									/**
									 * Set OMEGA, if necessary.
									 */
									if (predecessor.getMarking().isLessOrEqual(
											newMarking)) {
										pit = newMarking.iterator();
										while (pit.hasNext()) {
											place = (Place) pit.next();
											if (predecessor.getMarking()
													.getTokens(place) < newMarking
													.getTokens(place)) {
												// Token generator found for
												// place,
												// set to OMEGA
												newMarking.addPlace(place,
														Marking.OMEGA);
												isExtended = true;
											}
										}
									}
									/**
									 * Add all predecessors not yet seen.
									 */
									Iterator it2 = predecessor
											.getInEdgesIterator();
									while (it2.hasNext()) {
										Edge edge = (Edge) it2.next();
										ModelGraphVertex vertex = (ModelGraphVertex) edge
												.getTail();
										if (vertex instanceof State) {
											State newPredecessor = (State) vertex;
											if (!predecessors
													.contains(newPredecessor)) {
												predecessors
														.add(newPredecessor);
												predecessorsToDo
														.addLast(newPredecessor);
											}
										}
									}
								}
							} else {
								/**
								 * Use only spanning tree predecessors.
								 */
								State predecessor = state;
								while (predecessor != null) {
									if (predecessor.getMarking().isLessOrEqual(
											newMarking)) {
										pit = newMarking.iterator();
										while (pit.hasNext()) {
											place = (Place) pit.next();
											if (predecessor.getMarking()
													.getTokens(place) < newMarking
													.getTokens(place)) {
												// Token generator found for
												// place,
												// set to OMEGA
												newMarking.addPlace(place,
														Marking.OMEGA);
												isExtended = true;
											}
										}
									}
									predecessor = predecessor.getPredecessor();
								}
							}
							// Check whether the extended marking is already
							// present
							if (isExtended && treeMap.containsKey(newMarking)) {
								newState = (State) treeMap.get(newMarking);
								isFresh = false;
							}
						}
						if (isFresh) { // If the marking is fresh in the
							// coverability graph
							// Add the corresponding state
							graph.addState(newState);
							// HV
							if (newMarking.equals(sinkMarking)) {
								graph.addAcceptState(newState);
							}
							// Set its predecessor
							newState.setPredecessor(state);
							// Register its marking
							treeMap.put(newMarking, newState);
							// And have it expanded some time.
							if (expandUnboundedStates
									|| (newState.getMarking().getTokenCount() != Marking.OMEGA)) {
								toDo.addLast(newState);
							}

							// / if depth limitation is to be kept track of,
							// record the
							// / distance for sub states to be expanded later
							if (currentDistance > 0) {
								depthLevel.put(newState, new Integer(
										currentDistance - 1));
							}
						}
						// Add edge to the state.
						// HV ModelGraphEdge edge = graph.addEdge(new
						// ModelGraphEdge(state, newState));
						FSMTransition edge = new FSMTransition(state, newState,
								transition.getIdentifier());
						graph.addEdge(edge);
						edge.object = transition;
					}
				}
			}
		}
		if (!toDo.isEmpty()) {
			System.out
					.println("Insufficient memory available to construct complete coverability graph. Constructed coverability graph is truncated!");
			// Message
			// .add(
			// "Insufficient memory available to construct complete coverability graph. Constructed coverability graph is truncated!",
			// Message.ERROR);
		}
		return graph;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findModelsShouldBeRemoved("cleanedEpcPnml", "removelist.txt");
		// removeFiles("cleanedEpcPnml", "removelist.txt");
	}

}
