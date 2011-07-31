package basicparser.programflow;

import basicparser.ASTExpression;

import java.lang.RuntimeException;
import java.lang.String;

public class Loop extends Construct implements ConstructContainer {
	private final ASTExpression initialValue;
	private final ASTExpression upperBoundary;
	private final ASTExpression step;
	private final String variable;
	private Construct first = null;

	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

	
	public void push(Construct construct) {
		if(first == null) {
			first = construct;
		}
		else {
			Construct c;
			for(c = first; c.getNext() != null; c = c.getNext()) ;
			c.setNext(construct);
		}
	}

	public Loop(ASTExpression initialValue, ASTExpression upperBoundary, String variable) {
		this.initialValue = initialValue;
		this.upperBoundary = upperBoundary;
		this.variable = variable;
		this.step = null;
	}

	public Loop(ASTExpression initialValue, ASTExpression upperBoundary, ASTExpression step, String variable) {
		this.initialValue = initialValue;
		this.upperBoundary = upperBoundary;
		this.step = step;
		this.variable = variable;
	}

	public Construct getFirst() {
		return first;
	}

	public String translateBy(Construct child) {
		boolean foundChild = false;
		for(Construct c = first; c != null; c = c.getNext()) {
			if(c.equals(child)) {
				foundChild = true;
				break;
			}
		}
		if(!foundChild) {
			throw new RuntimeException("Called translateBy with an invalid child " + child.getLabel() + " " + child);
		}

		String result = "";
		//first translate starting from the child till the end
		for(Construct c = child; c != null; c = c.getNext()) {
			result += c.translate() + LINE_SEPARATOR;
		}
		//then increment the counter
		result += variable + " = MultiNumber.add(" + variable + ", " + (step != null ? ExpressionTranslator.instance().translate(step) : "1") + ");" + LINE_SEPARATOR;
		//then translate the loop in a normal way but without the initial assignment
		result += translate(true);

		return result;
	}

	public String translate() {
		return translate(false);
	}

	private String translate(boolean skipAssignment) {
		String result = "for(";
		result +=
				skipAssignment
				? "; "
				: variable + ".assign(" + ExpressionTranslator.instance().translate(initialValue) + "); ";
		result +=
				"MultiNumber.lt( " + variable + "," + ExpressionTranslator.instance().translate(upperBoundary) + ").isTrue(); " +
				variable + " = MultiNumber.add(" + variable + ", " + (step != null ? ExpressionTranslator.instance().translate(step) : "1") + ")) {" + LINE_SEPARATOR;
		for(Construct c = first; c != null; c = c.getNext()) {
			result += c.translate() + LINE_SEPARATOR;
		}
		result += "}";
		return result;
	}
}