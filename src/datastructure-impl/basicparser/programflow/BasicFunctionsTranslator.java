package basicparser.programflow;

import basicparser.*;
import basicparser.emu.BasicEmu;

import java.lang.String;

public class BasicFunctionsTranslator {
	private ASTExpression [] getParameters(SimpleNode function) {
		ASTExpression [] parameters = new ASTExpression[function.jjtGetChild(0).jjtGetNumChildren()];

		for (int i = 0; i < parameters.length; i++) {
			parameters[i] = (ASTExpression)function.jjtGetChild(0).jjtGetChild(i).jjtGetChild(0);
		}
		return parameters;
	}
	
	public String translate(ASTCosine cos) {
		ASTExpression parameter = (ASTExpression) cos.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"cos\"," + javaParameter + ")";
		return result;
	}
	
	public String translate(ASTAscii ascii) {
		ASTExpression parameter = (ASTExpression) ascii.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "BasicEmu.instance().asc(" + javaParameter + ");";
		return result;
	}
	
	public String translate(ASTChar chr) {
		ASTExpression parameter = (ASTExpression) chr.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "BasicEmu.instance().chr(" + javaParameter + ");";
		return result;
	}
	
	public String translate(ASTLength len){
		ASTExpression parameter = (ASTExpression) len.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "new MultiNumber(new String(" + javaParameter + ").length());";
		return result;
	}

	public String translate(ASTAbsolute abs) {
		ASTExpression parameter = (ASTExpression) abs.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"abs\"," + javaParameter + ")";
		return result;
	}
	
	public String translate(ASTSignum sgn){
		ASTExpression parameter = (ASTExpression) sgn.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.sgn("+ javaParameter + ")";
		return result;
	}

	public String translate(ASTAtan atan) {
		ASTExpression parameter = (ASTExpression)atan.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"atan\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTExponent exp) {
		ASTExpression parameter = (ASTExpression)exp.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.exp(new MultiNumber(Math.E),"+ javaParameter + ")";
		return result;
	}

	public String translate(ASTLogarithm log) {
		ASTExpression parameter = (ASTExpression)log.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"log\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTMaxint maxint) {
		ASTExpression parameter = (ASTExpression)maxint.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"ceil\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTSine asine) {
		ASTExpression parameter = (ASTExpression)asine.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"sin\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTSquareroot sqr) {
		ASTExpression parameter = (ASTExpression)sqr.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"sqrt\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTNumToStr numtostr) {
		ASTExpression parameter = (ASTExpression)numtostr.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "new MultiNumber(" + javaParameter + ").toString();";
		return result;
	}

	public String translate(ASTTangens tangens) {
		ASTExpression parameter = (ASTExpression) tangens.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "MultiNumber.mathFunction(" + "\"tan\"," + javaParameter + ")";
		return result;
	}

	public String translate(ASTStrToNum strtonum) {
		ASTExpression parameter = (ASTExpression)strtonum.jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
		String javaParameter = ExpressionTranslator.instance().translate(parameter);
		String result = "BasicEmu.instance().strToNum(" + javaParameter + ");";
		return result;
	}
	
	public String translate(ASTLeft left){
		ASTExpression [] parameters = getParameters(left);
		String stringParameter = ExpressionTranslator.instance().translate(parameters[0]);
		String numParameter = ExpressionTranslator.instance().translate(parameters[1]);
		String result = "BasicEmu.instance().left(" + stringParameter + "," + numParameter + ");";
		return result;
	}
	
	public String translate(ASTRight right){
		ASTExpression [] parameters = getParameters(right);
		String stringParameter = ExpressionTranslator.instance().translate(parameters[0]);
		String numParameter = ExpressionTranslator.instance().translate(parameters[1]);
		String result = "BasicEmu.instance().right(" + stringParameter + "," + numParameter + ");";
		return result;
	}
	
	public String translate(ASTSubstring mid){
		ASTExpression [] parameters = getParameters(mid);
		String stringParameter = ExpressionTranslator.instance().translate(parameters[0]);
		String startParameter = ExpressionTranslator.instance().translate(parameters[1]);
		String endParameter = ExpressionTranslator.instance().translate(parameters[1]);
		String result = "BasicEmu.instance().mid(" + stringParameter + "," + startParameter + "," + endParameter + ");";
		return result;
	}
	
	public String translate(ASTRandom rnd){
		ASTExpression [] parameters = getParameters(rnd);
		String numParameter = ExpressionTranslator.instance().translate(parameters[0]);
		String result = "BasicEmu.instance().rnd(" + numParameter + ");";
		return result;
	}
	
	public String translate(ASTSpace spc){
		ASTExpression [] parameters = getParameters(spc);
		String numParameter = ExpressionTranslator.instance().translate(parameters[0]);
		String result = "BasicEmu.instance().spc(" + numParameter + ");";
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