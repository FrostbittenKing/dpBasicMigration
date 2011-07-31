package basicparser.programflow;

import basicparser.ASTAscii;
import basicparser.ASTChar;
import basicparser.ASTLeft;
import basicparser.ASTRandom;
import basicparser.ASTExpression;
import basicparser.ASTBasicFunctions;
import basicparser.ASTRight;
import basicparser.ASTSpace;
import basicparser.ASTStrToNum;
import basicparser.ASTSubstring;
import basicparser.ASTprintStatement;
import basicparser.ASTTab;
import basicparser.Node;
import basicparser.SimpleNode;

public class Print extends Instruction{
	private ASTprintStatement printStatement;
	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);


	public Print(ASTprintStatement printStatement){
		this.printStatement = printStatement;
	}

	@Override
	public String translate(){

		String printText = null;
		ASTExpression[] expressions = new ASTExpression[printStatement.jjtGetChild(0).jjtGetNumChildren()];

		if(expressions.length > 0) {
			printText= "BasicEmu.instance().startPrint();" + LINE_SEPARATOR;
		}

		for(int i = 0; i < expressions.length; i++) {

			expressions[i] = (ASTExpression) printStatement.jjtGetChild(0).jjtGetChild(i);
			/*Node basicFunction;
			if ((basicFunction = expressions[i].jjtGetChild(0).jjtGetChild(0)) instanceof ASTBasicFunctions) {
				
				if (basicFunction.jjtGetChild(0) instanceof ASTRandom
						|| basicFunction.jjtGetChild(0) instanceof ASTLeft
						|| basicFunction.jjtGetChild(0) instanceof ASTRight
						|| basicFunction.jjtGetChild(0) instanceof ASTSubstring
						|| basicFunction.jjtGetChild(0) instanceof ASTChar
						|| basicFunction.jjtGetChild(0) instanceof ASTStrToNum
						|| basicFunction.jjtGetChild(0) instanceof ASTSpace
						|| basicFunction.jjtGetChild(0) instanceof ASTTab
						|| basicFunction.jjtGetChild(0) instanceof ASTAscii) {
					printText += "System.out.print(" + ExpressionTranslator.instance().translate(expressions[i]) + ");" + LINE_SEPARATOR;
				}
			}*/

			//else {
				printText += "BasicEmu.instance().print(" + ExpressionTranslator.instance().translate(expressions[i]) + ");" + LINE_SEPARATOR;
			//}
		}



	/*	for (int i = 1; i < expressions.length; i++) {
			printText += " + \" \" + " + ExpressionTranslator.instance().translate(expressions[i]);
		}
*/
		printText += "BasicEmu.instance().endPrint();" + LINE_SEPARATOR;
		
		return printText;
	}
}

