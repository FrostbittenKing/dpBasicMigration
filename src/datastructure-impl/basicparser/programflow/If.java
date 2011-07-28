package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.Construct;
import basicparser.programflow.ConstructContainer;
import basicparser.programflow.ExpressionTranslator;

import javax.sound.midi.Sequence;
import java.lang.String;

public class If extends Construct implements ConstructContainer {
	private ASTExpression condition;
	private Construct instruction;

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
		String result = "if(" + ExpressionTranslator.instance().translate(condition) + ".isTrue()) {\r\n";
		result += instruction.translate() + "\r\n";
		result += "}";
		return result;
	}

	public String translateBy(Construct child) {
		return translate();
	}
}