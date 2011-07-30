package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.ASTSpace;
import basicparser.ASTTab;
import basicparser.emu.BasicEmu;

public class Print extends Instruction{
	private ASTExpression [] printExpressions;
	
	public Print(ASTExpression [] exp){
		this.printExpressions = exp;
	}
	
	@Override
	public String translate(){
		String printText = "BasicEmu.instance().startPrint();\r\n";
		
		for (int i = 0; i < printExpressions.length; i++){
			if (printExpressions[i].jjtGetChild(0).jjtGetChild(0) instanceof ASTTab){
				printText += "BasicEmu.instance().tab(" + ((ASTTab)printExpressions[i].jjtGetChild(0).jjtGetChild(0)).getParameterVomTab() + ");\r\n";
			}
			else if (printExpressions[i].jjtGetChild(0).jjtGetChild(0) instanceof ASTSpace){
				printText += "BasicEmu.instance().spc(" + ((ASTSpace)printExpressions[i].jjtGetChild(0).jjtGetChild(0)).getParameterVomSpace() + ");\r\n";
			}
			else if //do normal print text
		}
		
		
		/*
		if(printExpressions.length > 0) {
			printText= ExpressionTranslator.instance().translate(printExpressions[0]);
		}
		
		for (int i = 1; i < printExpressions.length; i++) {
			printText += " + \" \" + " + ExpressionTranslator.instance().translate(printExpressions[i]);
		}
		*/
	
		return printText;
	}
}

