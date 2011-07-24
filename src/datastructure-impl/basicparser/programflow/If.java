package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.ExpressionTranslator;

import javax.sound.midi.Sequence;
import java.lang.String;

public class If extends Construct {
	private ASTExpression condition;
	private Instruction instruction;

	public If(ASTExpression condition) {
		this.condition = condition;
	}

	public String translate() {
		String result = "if(" + ExpressionTranslator.instance().translate(condition) + ".isTrue()) {\r\n";
		result += instruction.translate() + "\r\n";
		result += "}";
		return result;
	}
}