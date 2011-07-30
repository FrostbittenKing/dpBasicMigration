package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.ASTBasicFunctions;
import basicparser.ASTprintStatement;
import basicparser.ASTTab;
import basicparser.Node;
import basicparser.SimpleNode;

public class Print extends Instruction{
	private ASTprintStatement printStatement;

	public Print(ASTprintStatement printStatement){
		this.printStatement = printStatement;
	}

	@Override
	public String translate(){

		String printText = null;
		ASTExpression[] expressions = new ASTExpression[printStatement.jjtGetChild(0).jjtGetNumChildren()];

		if(expressions.length > 0) {
			printText= "BasicEmu.instance().startPrint();\n";
		}

		for(int i = 0; i < expressions.length; i++) {

			expressions[i] = (ASTExpression) printStatement.jjtGetChild(0).jjtGetChild(i);
			if (expressions[i].jjtGetChild(0).jjtGetChild(0) instanceof ASTBasicFunctions) {
				printText += "System.out.print(" + ExpressionTranslator.instance().translate(expressions[i]) + ");\n";
			}

			else {
				printText += "System.out.print(BasicEmu.instance().print(" + ExpressionTranslator.instance().translate(expressions[i]) + "));\n";
			}
		}



	/*	for (int i = 1; i < expressions.length; i++) {
			printText += " + \" \" + " + ExpressionTranslator.instance().translate(expressions[i]);
		}
*/
		printText += "BasicEmu.instance().endPrint();\n";
		
		return printText;
	}
}

