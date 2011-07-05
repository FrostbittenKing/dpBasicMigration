package programflow;

import programflow.Instruction;

import javax.sound.midi.Sequence;
import java.lang.String;

public class If extends Construct {
	private String condition;
	private Instruction instruction;

	public If(String condition) {
		this.condition = condition;
	}

	public String translate() {
		String result = "if(" + condition + ") {\r\n";
		result += instruction.translate() + "\r\n";
		result += "}\r\n";
		return result;
	}
}