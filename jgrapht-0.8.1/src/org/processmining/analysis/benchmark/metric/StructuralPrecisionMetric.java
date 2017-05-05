/***********************************************************
 *      This software is part of the ProM package          *
 *             http://www.processmining.org/               *
 *                                                         *
 *            Copyright (c) 2003-2007 TU/e Eindhoven       *
 *                and is licensed under the                *
 *            Common Public License, Version 1.0           *
 *        by Eindhoven University of Technology            *
 *           Department of Information Systems             *
 *                 http://is.tm.tue.nl                     *
 *                                                         *
 **********************************************************/

package org.processmining.analysis.benchmark.metric;

import org.processmining.framework.models.petrinet.PetriNet;
import org.processmining.framework.log.LogReader;
import org.processmining.framework.ui.Progress;
import org.processmining.framework.models.heuristics.HeuristicsNet;
import org.processmining.converting.PetriNetToHeuristicNetConverter;
import org.processmining.mining.geneticmining.analysis.duplicates.ConnectionEquivalent;

/**
 * 
 * @author Ana Karla A. de Medeiros
 * @version 1.0
 */
public class StructuralPrecisionMetric implements BenchmarkMetric {

	public StructuralPrecisionMetric() {
	}

	/**
	 * Calculates the "Structural Precision" metric for a given mined model with
	 * respect to a log and a reference model.
	 * 
	 * @param model
	 *            The resulting Petri net generated by a mining algorithm.
	 * @param referenceLog
	 *            This parameter is not used for this metric. Therefore, it can
	 *            be <code>null</code>
	 * @param referenceModel
	 *            The Petri net used to measure structural precision of the
	 *            mined model.
	 * @param progress
	 *            Progress
	 * @return The structural precision value (<code>[0, 1]</code>) of the mined
	 *         model. If the structural precision value cannot be calculated,
	 *         the value <code>BenchmarkMetric.INVALID_MEASURE_VALUE</code> is
	 *         returned.
	 */
	public double measure(PetriNet model, LogReader referenceLog,
			PetriNet referenceModel, Progress progress) {

		try {
			HeuristicsNet HNmodel = new PetriNetToHeuristicNetConverter()
					.toHeuristicsNet(PetriNetToHeuristicNetConverter
							.removeUnnecessaryInvisibleTasksFromPetriNet((PetriNet) model
									.clone()));
			HeuristicsNet HNreferenceModel = new PetriNetToHeuristicNetConverter()
					.toHeuristicsNet(PetriNetToHeuristicNetConverter
							.removeUnnecessaryInvisibleTasksFromPetriNet((PetriNet) referenceModel
									.clone()));
			ConnectionEquivalent structuralMetrics = new ConnectionEquivalent(
					HNreferenceModel, HNmodel);
			return structuralMetrics.getPrecision();
		} catch (Exception e) {
			System.err
					.println("StructuralPrecisionMetric >>> Could not calculate the structural precision value!");
			e.printStackTrace();

		}
		return BenchmarkMetric.INVALID_MEASURE_VALUE;
	}

	/**
	 * 
	 * @return The name of this metric. Namely, "Structural Precision"
	 */
	public String name() {
		return "Structural Precision SP";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.processmining.analysis.benchmark.metric.BenchmarkMetric#description()
	 */
	public String description() {
		return "The metric <b>structural precision S<sub>P</sub></b> quantifies "
				+ "how many connections the mined model has in common with the reference model. "
				+ "See also the metric <b>structural recall S<sub>R</sub></b>.";
	}

	/**
	 * This metric does not need a reference log.
	 * 
	 * @return <code>false</code>
	 */
	public boolean needsReferenceLog() {
		return false;
	}

	/**
	 * This metric needs a reference model.
	 * 
	 * @return <code>true</code>
	 */
	public boolean needsReferenceModel() {
		return true;
	}
}
