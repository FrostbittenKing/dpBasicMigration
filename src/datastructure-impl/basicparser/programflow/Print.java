package basicparser.programflow;

import basicparser.ASTExpression;

public class Print extends Instruction{
	private ASTExpression [] printExpressions;
	
	public Print(ASTExpression [] exp){
		this.printExpressions = exp;
	}
	
	@Override
	public String translate(){
		String printText = null;
		if(printExpressions.length > 0) {
			printText= ExpressionTranslator.instance().translate(printExpressions[0]);
		}
		
		for (int i = 1; i < printExpressions.length; i++) {
			printText += " + \" \" + " + ExpressionTranslator.instance().translate(printExpressions[i]);
		}
	
		return "System.out.println(" + printText + ");";
	}
}

