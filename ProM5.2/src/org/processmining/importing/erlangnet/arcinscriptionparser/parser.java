//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Dec 04 10:25:41 CET 2007
//----------------------------------------------------

package org.processmining.importing.erlangnet.arcinscriptionparser;

import java.util.*;
import java_cup.runtime.*;
import org.processmining.framework.models.erlangnet.inscription.*;
import org.processmining.framework.models.erlangnet.statement.*;
import org.processmining.framework.models.erlangnet.expression.*;

/**
 * CUP v0.11a beta 20060608 generated parser.
 * 
 * @version Tue Dec 04 10:25:41 CET 2007
 */
public class parser extends java_cup.runtime.lr_parser {

	/** Default constructor. */
	public parser() {
		super();
	}

	/** Constructor which sets the default scanner. */
	public parser(java_cup.runtime.Scanner s) {
		super(s);
	}

	/** Constructor which sets the default scanner. */
	public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {
		super(s, sf);
	}

	/** Production table. */
	protected static final short _production_table[][] = unpackFromStrings(new String[] { "\000\021\000\002\002\007\000\002\002\004\000\002\002"
			+ "\011\000\002\002\016\000\002\003\003\000\002\003\012"
			+ "\000\002\003\013\000\002\003\016\000\002\004\003\000"
			+ "\002\004\004\000\002\004\004\000\002\004\004\000\002"
			+ "\004\004\000\002\004\006\000\002\004\010\000\002\005"
			+ "\005\000\002\005\003" });

	/** Access to production table. */
	public short[][] production_table() {
		return _production_table;
	}

	/** Parse-action table. */
	protected static final short[][] _action_table = unpackFromStrings(new String[] { "\000\106\000\004\004\005\001\002\000\004\002\110\001"
			+ "\002\000\006\006\007\011\006\001\002\000\004\022\103"
			+ "\001\002\000\004\022\010\001\002\000\012\007\013\010"
			+ "\015\014\012\023\011\001\002\000\004\004\070\001\002"
			+ "\000\004\004\060\001\002\000\004\005\ufffd\001\002\000"
			+ "\004\005\057\001\002\000\004\004\016\001\002\000\004"
			+ "\024\017\001\002\000\004\022\020\001\002\000\020\012"
			+ "\021\013\022\015\023\016\026\017\025\020\024\025\027"
			+ "\001\002\000\004\004\051\001\002\000\004\004\044\001"
			+ "\002\000\004\011\040\001\002\000\004\030\037\001\002"
			+ "\000\006\024\036\027\035\001\002\000\004\026\034\001"
			+ "\002\000\006\005\ufff9\022\ufff9\001\002\000\004\022\031"
			+ "\001\002\000\010\007\013\010\015\023\011\001\002\000"
			+ "\004\005\033\001\002\000\004\005\ufffc\001\002\000\006"
			+ "\005\ufff6\022\ufff6\001\002\000\006\005\ufff8\022\ufff8\001"
			+ "\002\000\006\005\ufff7\022\ufff7\001\002\000\006\005\ufff5"
			+ "\022\ufff5\001\002\000\004\022\041\001\002\000\004\007"
			+ "\042\001\002\000\004\005\043\001\002\000\004\005\ufffb"
			+ "\001\002\000\004\024\045\001\002\000\004\022\046\001"
			+ "\002\000\004\007\047\001\002\000\004\005\050\001\002"
			+ "\000\006\005\ufff3\022\ufff3\001\002\000\016\012\021\013"
			+ "\022\016\026\017\025\020\024\025\027\001\002\000\006"
			+ "\005\ufff1\022\055\001\002\000\004\005\054\001\002\000"
			+ "\006\005\ufff4\022\ufff4\001\002\000\016\012\021\013\022"
			+ "\016\026\017\025\020\024\025\027\001\002\000\004\005"
			+ "\ufff2\001\002\000\004\002\001\001\002\000\004\024\061"
			+ "\001\002\000\004\022\062\001\002\000\004\007\063\001"
			+ "\002\000\004\005\064\001\002\000\004\022\065\001\002"
			+ "\000\016\012\021\013\022\016\026\017\025\020\024\025"
			+ "\027\001\002\000\004\005\067\001\002\000\004\002\ufffe"
			+ "\001\002\000\004\024\071\001\002\000\004\022\072\001"
			+ "\002\000\004\011\073\001\002\000\004\022\074\001\002"
			+ "\000\004\024\075\001\002\000\004\022\076\001\002\000"
			+ "\004\025\077\001\002\000\004\022\100\001\002\000\010"
			+ "\007\013\010\015\023\011\001\002\000\004\005\102\001"
			+ "\002\000\004\005\ufffa\001\002\000\004\006\104\001\002"
			+ "\000\004\022\105\001\002\000\016\012\021\013\022\016"
			+ "\026\017\025\020\024\025\027\001\002\000\004\005\107"
			+ "\001\002\000\004\002\uffff\001\002\000\004\002\000\001" + "\002" });

	/** Access to parse-action table. */
	public short[][] action_table() {
		return _action_table;
	}

	/** <code>reduce_goto</code> table. */
	protected static final short[][] _reduce_table = unpackFromStrings(new String[] { "\000\106\000\004\002\003\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\004"
			+ "\003\013\001\001\000\002\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\004\004\027\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\004\003\031\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\002\001\001\000\002\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\006\004\051\005\052\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\006\004\051\005\055\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\004\004"
			+ "\065\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\002\001\001\000\004\003\100\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\004\004\105\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001" });

	/** Access to <code>reduce_goto</code> table. */
	public short[][] reduce_table() {
		return _reduce_table;
	}

	/** Instance of action encapsulation class. */
	protected CUP$parser$actions action_obj;

	/** Action encapsulation object initializer. */
	protected void init_actions() {
		action_obj = new CUP$parser$actions(this);
	}

	/** Invoke a user supplied parse action. */
	public java_cup.runtime.Symbol do_action(int act_num,
			java_cup.runtime.lr_parser parser, java.util.Stack stack, int top)
			throws java.lang.Exception {
		/* call code in generated class */
		return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
	}

	/** Indicates start state. */
	public int start_state() {
		return 0;
	}

	/** Indicates start production. */
	public int start_production() {
		return 1;
	}

	/** <code>EOF</code> Symbol index. */
	public int EOF_sym() {
		return 0;
	}

	/** <code>error</code> Symbol index. */
	public int error_sym() {
		return 1;
	}

	public void report_error(String message, Object info) { /*
															 * Ignore simple
															 * error
															 */
	}

	public void report_fatal_error(String message, Object info)
			throws Exception {
		StringBuffer m = new StringBuffer("Error");

		if (info instanceof java_cup.runtime.Symbol) {
			java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

			if (s.left >= 0) {
				m.append(" in line " + (s.left + 1));
				if (s.right >= 0)
					m.append(", column " + (s.right + 1));
			}
		}

		m.append(" : " + message);

		throw new Exception(m.toString());
	}

}

/** Cup generated class to encapsulate user supplied action code. */
class CUP$parser$actions {

	public String sid(Object o) {
		String s = (String) o;
		return s.substring(1, s.length() - 1);
	}

	private final parser parser;

	/** Constructor */
	CUP$parser$actions(parser parser) {
		this.parser = parser;
	}

	/** Method with the actual generated action code. */
	public final java_cup.runtime.Symbol CUP$parser$do_action(
			int CUP$parser$act_num,
			java_cup.runtime.lr_parser CUP$parser$parser,
			java.util.Stack CUP$parser$stack, int CUP$parser$top)
			throws java.lang.Exception {
		/* Symbol object for return from actions */
		java_cup.runtime.Symbol CUP$parser$result;

		/* select the action based on the action number */
		switch (CUP$parser$act_num) {
		/* . . . . . . . . . . . . . . . . . . . . */
		case 16: // exp_list ::= expression
		{
			List<Expression> RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).right;
			Expression e = (Expression) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			List<Expression> expList = new ArrayList<Expression>();
			expList.add(e);
			RESULT = expList;
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"exp_list",
							3,
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 15: // exp_list ::= expression COMMA exp_list
		{
			List<Expression> RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Expression e = (Expression) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int elleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int elright = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).right;
			List<Expression> el = (List<Expression>) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			el.add(e);
			RESULT = el;
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"exp_list",
							3,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 2)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 14: // expression ::= GET LPAREN STRINGID COMMA ENV RPAREN
		{
			Expression RESULT = null;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			Object id = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			RESULT = new IdentifierExpression(sid(id));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 5)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 13: // expression ::= ID LPAREN exp_list RPAREN
		{
			Expression RESULT = null;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			Object id = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int elleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int elright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			List<Expression> el = (List<Expression>) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new FunctionCallExpression((String) id, el);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 3)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 12: // expression ::= BOOLTYPE BOOL
		{
			Expression RESULT = null;
			int boolleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int boolright = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).right;
			Object bool = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			RESULT = new BooleanExpression(Boolean.parseBoolean((String) bool));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 1)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 11: // expression ::= INTTYPE INT
		{
			Expression RESULT = null;
			int integerleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).left;
			int integerright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).right;
			Object integer = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			RESULT = new IntegerExpression(Integer.parseInt((String) integer));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 1)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 10: // expression ::= STRINGTYPE STRINGID
		{
			Expression RESULT = null;
			int stringleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int stringright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).right;
			Object string = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			RESULT = new StringExpression(sid(string));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 1)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 9: // expression ::= STRINGTYPE STRING
		{
			Expression RESULT = null;
			int stringleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int stringright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).right;
			Object string = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			RESULT = new StringExpression(sid(string));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 1)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 8: // expression ::= VALUE
		{
			Expression RESULT = null;
			RESULT = new ValueExpression();
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"expression",
							2,
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 7: // statement ::= SM LPAREN STRINGID COMMA SENDER COMMA STRINGID
			// COMMA VALUE COMMA statement RPAREN
		{
			Statement RESULT = null;
			int senderleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 9)).left;
			int senderright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 9)).right;
			Object sender = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 9)).value;
			int varleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).left;
			int varright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).right;
			Object var = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).value;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Statement s = (Statement) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new ReceiveSenderAndValueStatement(sid(sender), sid(var));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"statement",
							1,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 11)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 6: // statement ::= SET LPAREN STRINGID COMMA PIDTYPE SENDER COMMA
			// ENV RPAREN
		{
			Statement RESULT = null;
			int senderleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).left;
			int senderright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).right;
			Object sender = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).value;
			RESULT = new ReceiveSenderStatement(sid(sender));
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"statement",
							1,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 8)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 5: // statement ::= SET LPAREN STRINGID COMMA expression COMMA
			// statement RPAREN
		{
			Statement RESULT = null;
			int varleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).left;
			int varright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).right;
			Object var = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			Expression e = (Expression) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Statement s = (Statement) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new AssignmentStatement(sid(var), e, s);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"statement",
							1,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 7)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 4: // statement ::= ENV
		{
			Statement RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).right;
			Object e = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.peek()).value;
			RESULT = new NoOperationStatement((String) e);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"statement",
							1,
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 3: // inscription ::= LPAREN PID COMMA GETPID LPAREN STRINGID COMMA
			// ENV RPAREN COMMA expression RPAREN
		{
			ArcInscription RESULT = null;
			int receiverleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).left;
			int receiverright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).right;
			Object receiver = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 6)).value;
			int expleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int expright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Expression exp = (Expression) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new SendMessageInscription(sid(receiver), exp);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"inscription",
							0,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 11)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 2: // inscription ::= LPAREN SENDER COMMA PID COMMA expression
			// RPAREN
		{
			ArcInscription RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Expression e = (Expression) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new ReceiveMessageInscription(e);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"inscription",
							0,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 6)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 1: // $START ::= inscription EOF
		{
			Object RESULT = null;
			int start_valleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int start_valright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArcInscription start_val = (ArcInscription) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = start_val;
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"$START",
							0,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 1)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			/* ACCEPT */
			CUP$parser$parser.done_parsing();
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 0: // inscription ::= LPAREN PID COMMA statement RPAREN
		{
			ArcInscription RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Statement s = (Statement) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new RouteInscription(s);
			CUP$parser$result = parser
					.getSymbolFactory()
					.newSymbol(
							"inscription",
							0,
							((java_cup.runtime.Symbol) CUP$parser$stack
									.elementAt(CUP$parser$top - 4)),
							((java_cup.runtime.Symbol) CUP$parser$stack.peek()),
							RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . */
		default:
			throw new Exception(
					"Invalid action number found in internal parse table");

		}
	}
}
