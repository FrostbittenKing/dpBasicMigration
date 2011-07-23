package basicparser.programflow;

import basicparser.ASTAbsolute;
import basicparser.ASTAction;
import basicparser.ASTAdd;
import basicparser.ASTArray;
import basicparser.ASTArrayDeclaration;
import basicparser.ASTAscii;
import basicparser.ASTAtan;
import basicparser.ASTBasicFunctions;
import basicparser.ASTChar;
import basicparser.ASTComparisonExp;
import basicparser.ASTCosine;
import basicparser.ASTDimStatement;
import basicparser.ASTExp;
import basicparser.ASTExponent;
import basicparser.ASTExpression;
import basicparser.ASTFreeBytes;
import basicparser.ASTIf;
import basicparser.ASTIntToString;
import basicparser.ASTKeyCharacter;
import basicparser.ASTLeft;
import basicparser.ASTLength;
import basicparser.ASTLineNumber;
import basicparser.ASTLiteral;
import basicparser.ASTLogarithm;
import basicparser.ASTLogicalAnd;
import basicparser.ASTLogicalOr;
import basicparser.ASTMaxint;
import basicparser.ASTMult;
import basicparser.ASTName;
import basicparser.ASTNumberIdentifier;
import basicparser.ASTNumericExpressionParameter;
import basicparser.ASTParameter;
import basicparser.ASTParameterDeclaration;
import basicparser.ASTPosition;
import basicparser.ASTPrimaryExp;
import basicparser.ASTRandom;
import basicparser.ASTRelationalExp;
import basicparser.ASTRight;
import basicparser.ASTSignum;
import basicparser.ASTSimpleVariable;
import basicparser.ASTSine;
import basicparser.ASTSpace;
import basicparser.ASTSquareroot;
import basicparser.ASTStatement;
import basicparser.ASTStickX;
import basicparser.ASTStickY;
import basicparser.ASTStringIdentifier;
import basicparser.ASTStringLiteral;
import basicparser.ASTStringToInt;
import basicparser.ASTSubstring;
import basicparser.ASTTab;
import basicparser.ASTTangens;
import basicparser.ASTUnaryExpression;
import basicparser.ASTUserProgram;
import basicparser.ASTVariable;
import basicparser.ASTVariableLengthParameter;
import basicparser.ASTbrightStatement;
import basicparser.ASTclearStatement;
import basicparser.ASTcontStatement;
import basicparser.ASTcursorXStatement;
import basicparser.ASTcursorYStatement;
import basicparser.ASTdataStatement;
import basicparser.ASTdefStatement;
import basicparser.ASTdelimStatement;
import basicparser.ASTdisplayStatement;
import basicparser.ASTendStatement;
import basicparser.ASTforLoopStatement;
import basicparser.ASTfunctionDefBody;
import basicparser.ASTfunctionDefName;
import basicparser.ASTgosubStatement;
import basicparser.ASTgotoStatement;
import basicparser.ASTgrStatement;
import basicparser.ASTinitStatement;
import basicparser.ASTinputStatement;
import basicparser.ASTletStatement;
import basicparser.ASTlineStatement;
import basicparser.ASTlistStatement;
import basicparser.ASTnewStatement;
import basicparser.ASTnextStatement;
import basicparser.ASTonStatement;
import basicparser.ASTpageStatement;
import basicparser.ASTparseCommand;
import basicparser.ASTparseRoot;
import basicparser.ASTprintStatement;
import basicparser.ASTprintText;
import basicparser.ASTreadStatement;
import basicparser.ASTrestoreStatement;
import basicparser.ASTreturnStatement;
import basicparser.ASTrunStatement;
import basicparser.ASTscreenStatement;
import basicparser.ASTscrollStatement;
import basicparser.ASTsoundStatement;
import basicparser.ASTstopStatement;
import basicparser.ASTstoreStatement;
import basicparser.ASTtxStatement;
import basicparser.BasicParserVisitor;
import basicparser.SimpleNode;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLogicalOr node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLogicalAnd node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTComparisonExp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTRelationalExp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAdd node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTMult node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTUnaryExpression node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTPrimaryExp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTVariable node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTSimpleVariable node, Object data) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTStringIdentifier node, Object data) {
		
		return null;
	}

	@Override
	public Object visit(ASTNumberIdentifier node, Object data) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTLiteral node, Object data) {
		if (node.integerValue != null) {
			data = new MultiNumber(node.integerValue);
		}
		else {
			data = new MultiNumber(node.doubleValue);
		}
		return null;
	}

	@Override
	public Object visit(ASTStringLiteral node, Object data) {
		// TODO Auto-generated method stub
		return null;
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
	public Object visit(ASTBasicFunctions node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAbsolute node, Object data) {
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
		// TODO Auto-generated method stub
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
	public Object visit(ASTStringToInt node, Object data) {
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
	public Object visit(ASTIntToString node, Object data) {
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

}
