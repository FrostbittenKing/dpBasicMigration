package basicparser.programflow;

import basicparser.ASTExpression;

import java.lang.String;

public class Loop extends Construct implements ConstructContainer {
	private final ASTExpression initialValue;
	private final ASTExpression upperBoundary;
	private final ASTExpression step;
	private final String variable;
	private Construct first = null;

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

	public String translate() {
		String result =
				"for(" + variable + ".assign(" + ExpressionTranslator.instance().translate(initialValue) + "); " +
				variable + ".lt(" + ExpressionTranslator.instance().translate(upperBoundary) + "); " +
				variable + " = MultiNumber.add(" + variable + ", " + (step != null ? ExpressionTranslator.instance().translate(step) : "1") + ") {\r\n";
		for(Construct c = first; c != null; c = c.getNext()) {
			result += c.translate();
			result += "\r\n";
		}
		result += "}";
		return result;
	}
}