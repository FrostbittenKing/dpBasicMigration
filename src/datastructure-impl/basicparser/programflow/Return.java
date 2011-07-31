package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.ProgramGraph;

import java.lang.String;

public class Return extends Instruction {
	
	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

	
	public String translate() {
		String result =
				"if(!returnCallMethodNameStack.isEmpty()) {" + LINE_SEPARATOR +
				"\tnextCallMethodName = returnCallMethodNameStack.pop();" + LINE_SEPARATOR +
				"return;" +
				"}" + LINE_SEPARATOR;
		return result;
	}
}