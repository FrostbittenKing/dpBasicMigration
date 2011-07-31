package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.Construct;
import basicparser.programflow.ConstructContainer;
import basicparser.programflow.ExpressionTranslator;


import java.lang.String;

public class If extends Construct implements ConstructContainer {
	private ASTExpression condition;
	private Construct instruction;

	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

	public If(ASTExpression condition) {
		this.condition = condition;
	}

	public void push(Construct construct) {
		instruction = construct;
	}

	public Construct getFirst() {
		return instruction;
	}

	public String translate() {
		String result = "if(" + ExpressionTranslator.instance().translate(condition) + ".isTrue()) {" + LINE_SEPARATOR;
		result += instruction.translate() + LINE_SEPARATOR;
		result += "}";
		return result;
	}

	public String translateBy(Construct child) {
		return translate();
	}
}