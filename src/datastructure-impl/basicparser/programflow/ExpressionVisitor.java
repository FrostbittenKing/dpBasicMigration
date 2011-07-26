package basicparser.programflow;

import java.lang.reflect.Method;

import javax.management.ReflectionException;

import basicparser.*;

public class ExpressionVisitor implements BasicParserVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTparseRoot node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLineNumber node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTparseCommand node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTLogicalOr node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			returnVal = "MultiNumber.or(" + returnVal + "," + ((String[])(data))[i+1] + ")";
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTLogicalAnd node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			returnVal = "MultiNumber.and(" + returnVal + "," + ((String[])(data))[i+1] + ")";
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTComparisonExp node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			returnVal = "MultiNumber.compare(" + returnVal + "," + ((String[])(data))[i+1] + ")";
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTRelationalExp node, Object data) {
		String returnVal = ((String[])(data))[0];

		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			switch(node.typeList.get(i)) {
			case GreaterEqual:
				returnVal = "MultiNumber.ge(" + returnVal + "," + ((String[])(data))[i+1] + ")";
				break;

			case Greater:
				returnVal = "MultiNumber.gt(" + returnVal + "," + ((String[])(data))[i+1] + ")";
				break;

			case Lesser:
				returnVal = "MultiNumber.lt(" + returnVal + "," + ((String[])(data))[i+1] + ")";
				break;

			case LesserEqual:
				returnVal = "MultiNumber.le(" + returnVal + "," + ((String[])(data))[i+1] + ")";
				break;

			case Unequal:
				returnVal = "MultiNumber.ne(" + returnVal + "," + ((String[])(data))[i+1] + ")";
				break;
			}
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTAdd node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			if (node.typeList.get(i) == ASTAdd.Type.Add) {
				returnVal = "MultiNumber.add(" + returnVal + "," + ((String[])(data))[i+1] + ")";
			}
			else {
				returnVal = "MultiNumber.sub(" + returnVal + "," + ((String[])(data))[i+1] + ")";
			}
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTMult node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			if (node.typeList.get(i) == ASTMult.Type.Mul) {
				returnVal = "MultiNumber.mul(" + returnVal + "," + ((String[])(data))[i+1] + ")";
			}
			else {
				returnVal = "MultiNumber.div(" + returnVal + "," + ((String[])(data))[i+1] + ")";
			}
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		String returnVal = ((String[])(data))[0];
		for (int i = 0; i < node.jjtGetNumChildren()-1; i++) {
			returnVal = "MultiNumber.exp(" + returnVal + "," + ((String[])(data))[i+1] + ")";
		}
		return returnVal;
	}

	@Override
	public Object visit(ASTUnaryExpression node, Object data) {
		String returnVal = ((String[])(data))[0];
		if (node.isSignum()) {
			return "MultiNumber.toggleSignum(" + returnVal + ")";
		}
		else {
			return returnVal;
		}
	}

	@Override
	public Object visit(ASTPrimaryExp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTVariable node, Object data) {
		return ((Object[])data)[0];
	}

	@Override
	public Object visit(ASTSimpleVariable node, Object data) {
		return ((Object[])data)[0];
	}

	@Override
	public Object visit(ASTArray node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTArrayDeclaration node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTName node, Object data) {
		return ((Object[])data)[0];
	}

	@Override
	public Object visit(ASTStringIdentifier node, Object data) {
		return node.value;
	}

	@Override
	public Object visit(ASTNumberIdentifier node, Object data) {
		return node.value;
	}

	@Override
	public Object visit(ASTLiteral node, Object data) {
		if (node.integerValue != null) {
			return "new MultiNumber(" + node.integerValue + ")";
		}
		else {
			return "new MultiNumber(" + node.doubleValue + ")";
		}
	}

	@Override
	public Object visit(ASTStringLiteral node, Object data) {
		return node.stringValue;
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTNumericExpressionParameter node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTParameterDeclaration node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTVariableLengthParameter node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTParameter node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTBasicFunctions node, Object data){
		Class<?> basicFunctionsTranslator;
		String returnVal;
		try {
			basicFunctionsTranslator = Class.forName("basicparser.programflow.BasicFunctionsTranslator");
			Method method = basicFunctionsTranslator.getDeclaredMethod("translate", node.jjtGetChild(0).getClass());
			returnVal = (String)method.invoke(BasicFunctionsTranslator.instance(), node.jjtGetChild(0));
			return returnVal;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object visit(ASTAbsolute node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public Object visit(ASTendIf node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAction node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAscii node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAtan node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTCosine node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTChar node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExponent node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTFreeBytes node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLeft node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLength node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLogarithm node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTMaxint node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTSubstring node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTPosition node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTRandom node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTRight node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTSignum node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTSine node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTSpace node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTSquareroot node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTStickX node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTStickY node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTTab node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTTangens node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTUserProgram node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTKeyCharacter node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTbrightStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTclearStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTcontStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTcursorXStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTcursorYStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTfunctionDefName node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTdefStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTfunctionDefBody node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTdelimStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTDimStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTdisplayStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTendStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTgosubStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTreturnStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTgrStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTgotoStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTIf node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTinitStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTinputStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTletStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTlineStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTlistStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTnewStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTonStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTpageStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTreadStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTdataStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTrestoreStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTrunStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTscreenStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTscrollStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTsoundStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTstopStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTstoreStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTtxStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTforLoopStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTnextStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTprintStatement node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTprintText node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTNumToStr node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTStrToNum node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}



}
