package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.ProgramGraph;

import java.lang.String;

public class Return extends Instruction {
	public String translate() {
		String result =
				"if(!returnCallMethodNameStack.isEmpty()) {\n" +
				"\tnextCallMethodName = returnCallMethodNameStack.pop();\n" +
				"return;" +
				"}\n";
		return result;
	}
}