package basicparser.programflow;

import java.util.ArrayList;

/**
 * A statement is basically a line in the program, each statement will typically contain one instruction
 */
public class Statement {
	private int label;
	private Statement next;
	private ArrayList<Instruction> instructions = new ArrayList<Instruction>();

	public void addInstruction(Instruction instruction) {
		instructions.add(instruction);
	}

	public String translate() {
		return null;
	}
}
