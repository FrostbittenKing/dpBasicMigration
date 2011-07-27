package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.ProgramGraph;

import java.lang.String;

public class Gosub extends Instruction {
	private int returnTarget;

	public Gosub() {
	}

	public void setReturnTarget(int returnTarget) {
		this.returnTarget = returnTarget;
	}

	public String translate() {
		String result =
				ProgramGraph.RETURN_CALL_METHOD_NAME_STACK + ".push(\"" + ProgramGraph.RETURN_METHOD_PREFIX + returnTarget + "\");\r\n" +
				ProgramGraph.makeNextCallMethodNameAssignment(ProgramGraph.getGoMethodFromLabel(getNext().getLabel())) + "\r\n" +
				"return;";
		return result;
	}
}