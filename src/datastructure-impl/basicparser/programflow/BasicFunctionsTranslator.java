package basicparser.programflow;

import basicparser.*;

import java.lang.String;

public class BasicFunctionsTranslator {
	public String translate(ASTCosine cos) {
		ASTExpression parameter = (ASTExpression) cos.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.cos(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTAbsolute abs) {
		ASTExpression parameter = (ASTExpression) abs.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.abs(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTAtan atan) {
		ASTExpression parameter = (ASTExpression)atan.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.atan(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTExponent exp) {
		ASTExpression parameter = (ASTExpression)exp.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.pow(Math.E, " + javaParameter + ");";
		return result;
	}

	public String translate(ASTLogarithm log) {
		ASTExpression parameter = (ASTExpression)log.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.log(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTMaxint maxint) {
		ASTExpression parameter = (ASTExpression)maxint.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.ceil(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTSine asine) {
		ASTExpression parameter = (ASTExpression)asine.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.sin(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTSquareroot sqr) {
		ASTExpression parameter = (ASTExpression)sqr.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.sqrt(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTNumToStr numtostr) {
		ASTExpression parameter = (ASTExpression)numtostr.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "new Double(" + javaParameter + ").toString();";
		return result;
	}

	public String translate(ASTTangens tangens) {
		ASTExpression parameter = (ASTExpression) tangens.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "Math.tan(" + javaParameter + ");";
		return result;
	}

	public String translate(ASTStrToNum strtonum) {
		ASTExpression parameter = (ASTExpression)strtonum.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		Val val = new Val(javaParameter);
		String result = val.translate();
		return result;
	}

	public static BasicFunctionsTranslator instance() {
		if(instance == null) {
			instance = new BasicFunctionsTranslator();
		}
		return instance;
	}

	private static BasicFunctionsTranslator instance;
}