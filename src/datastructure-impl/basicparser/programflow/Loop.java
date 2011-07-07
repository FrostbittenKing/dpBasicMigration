package basicparser.programflow;

import java.lang.String;

public class Loop extends Construct {
	private final int initialValue;
	private final int upperBoundary;
	private final int step = 1;
	private final String variable;
	private Sequence body = new Sequence();

	public Loop(int initialValue, int upperBoundary, String variable) {
		this.initialValue = initialValue;
		this.upperBoundary = upperBoundary;
		this.variable = variable;
	}

	public Sequence getBody() {
		return body;
	}

	public String translate() {
		String result =
				"for(" + variable + " = " + initialValue + "; " +
				variable + " < " + upperBoundary + "; " +
				variable + " += " + step + ") {\r\n";
		result += body.translate();
		result += "}\r\n";
		return result;
	}
}