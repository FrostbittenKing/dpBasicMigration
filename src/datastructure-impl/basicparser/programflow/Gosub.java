package basicparser.programflow;

import basicparser.ASTExpression;

import java.lang.String;

public class Gosub extends Instruction {
	private int target;

	public Gosub(int target) {
		this.target = target;
	}

	public String translate() {
		String result =
				ProgramGraph.getGosubMethodFromLabel(target) + "();";
		return result;
	}
}