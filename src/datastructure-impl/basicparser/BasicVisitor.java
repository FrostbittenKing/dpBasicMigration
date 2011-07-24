package basicparser;

import java.lang.Integer;
import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.util.LinkedList;
import java.util.Stack;

import basicparser.*;
import basicparser.programflow.*;

public class BasicVisitor implements BasicParserVisitor {
	private LinkedList stack = new LinkedList();
	private Stack<ConstructContainer> containerStack = new Stack<ConstructContainer>();

	public BasicVisitor(ProgramGraph programGraph) {
		containerStack.push(programGraph);
	}

	public Object visit(SimpleNode node, Object data) {
		return null;
	}

	public Object visit(ASTparseRoot node, Object data) {
		return null;
	}

	public Object visit(ASTLineNumber node, Object data) {
		return null;
	}

	public Object visit(ASTparseCommand node, Object data) {
		return null;
	}

	public Object visit(ASTLogicalOr node, Object data) {
		return null;
	}

	public Object visit(ASTLogicalAnd node, Object data) {
		return null;
	}

	public Object visit(ASTComparisonExp node, Object data) {
		return null;
	}

	public Object visit(ASTRelationalExp node, Object data) {
		return null;
	}

	public Object visit(ASTAdd node, Object data) {
		return null;
	}

	public Object visit(ASTMult node, Object data) {
		return null;
	}

	public Object visit(ASTExp node, Object data) {
		return null;
	}

	public Object visit(ASTUnaryExpression node, Object data) {
		return null;
	}

	public Object visit(ASTPrimaryExp node, Object data) {
		return null;
	}

	public Object visit(ASTVariable node, Object data) {
		return null;
	}

	public Object visit(ASTSimpleVariable node, Object data) {
		return null;
	}

	public Object visit(ASTArray node, Object data) {
		return null;
	}

	public Object visit(ASTArrayDeclaration node, Object data) {
		return null;
	}

	public Object visit(ASTName node, Object data) {
		return null;
	}

	public Object visit(ASTStringIdentifier node, Object data) {
		return null;
	}

	public Object visit(ASTNumberIdentifier node, Object data) {
		return null;
	}

	public Object visit(ASTLiteral node, Object data) {
		return null;
	}

	public Object visit(ASTStatement node, Object data) {
		return null;
	}

	public Object visit(ASTNumericExpressionParameter node, Object data) {
		return null;
	}

	public Object visit(ASTParameterDeclaration node, Object data) {
		return null;
	}

	public Object visit(ASTVariableLengthParameter node, Object data) {
		return null;
	}

	public Object visit(ASTParameter node, Object data) {
		return null;
	}

	public Object visit(ASTBasicFunctions node, Object data) {
		return null;
	}

	public Object visit(ASTAbsolute node, Object data) {
		return null;
	}

	public Object visit(ASTAction node, Object data) {
		return null;
	}

	public Object visit(ASTAscii node, Object data) {
		return null;
	}

	public Object visit(ASTAtan node, Object data) {
		return null;
	}

	public Object visit(ASTCosine node, Object data) {
		return null;
	}

	public Object visit(ASTChar node, Object data) {
		return null;
	}

	public Object visit(ASTExponent node, Object data) {
		return null;
	}

	public Object visit(ASTFreeBytes node, Object data) {
		return null;
	}

	public Object visit(ASTLeft node, Object data) {
		return null;
	}

	public Object visit(ASTLength node, Object data) {
		return null;
	}

	public Object visit(ASTLogarithm node, Object data) {
		return null;
	}

	public Object visit(ASTMaxint node, Object data) {
		return null;
	}

	public Object visit(ASTSubstring node, Object data) {
		return null;
	}

	public Object visit(ASTPosition node, Object data) {
		return null;
	}

	public Object visit(ASTRandom node, Object data) {
		return null;
	}

	public Object visit(ASTRight node, Object data) {
		return null;
	}

	public Object visit(ASTSignum node, Object data) {
		return null;
	}

	public Object visit(ASTSine node, Object data) {
		return null;
	}

	public Object visit(ASTSpace node, Object data) {
		return null;
	}

	public Object visit(ASTSquareroot node, Object data) {
		return null;
	}

	public Object visit(ASTNumToStr node, Object data) {
		return null;
	}

	public Object visit(ASTStickX node, Object data) {
		return null;
	}

	public Object visit(ASTStickY node, Object data) {
		return null;
	}

	public Object visit(ASTTab node, Object data) {
		return null;
	}

	public Object visit(ASTTangens node, Object data) {
		return null;
	}

	public Object visit(ASTUserProgram node, Object data) {
		return null;
	}

	public Object visit(ASTStrToNum node, Object data) {
		return null;
	}

	public Object visit(ASTKeyCharacter node, Object data) {
		return null;
	}

	public Object visit(ASTbrightStatement node, Object data) {
		return null;
	}

	public Object visit(ASTclearStatement node, Object data) {
		return null;
	}

	public Object visit(ASTcontStatement node, Object data) {
		return null;
	}

	public Object visit(ASTcursorXStatement node, Object data) {
		return null;
	}

	public Object visit(ASTcursorYStatement node, Object data) {
		return null;
	}

	public Object visit(ASTfunctionDefName node, Object data) {
		return null;
	}

	public Object visit(ASTdefStatement node, Object data) {
		return null;
	}

	public Object visit(ASTfunctionDefBody node, Object data) {
		return null;
	}

	public Object visit(ASTdelimStatement node, Object data) {
		return null;
	}

	public Object visit(ASTDimStatement node, Object data) {
		for(ASTArrayDeclaration currentArrayDeclaration : node.arrayDeclarations) {
			if(currentArrayDeclaration.name instanceof ASTNumberIdentifier) {
				ASTNumberIdentifier numberIdentifier = (ASTNumberIdentifier) currentArrayDeclaration.name;
				LinkedList<Integer> dimensions = new LinkedList<Integer>();
				VariableTable.instance().getNumberArrays().put(numberIdentifier.value, dimensions);
				for(String parameter : currentArrayDeclaration.parameters) {
					dimensions.add(Integer.parseInt(parameter));
				}
			}
		}
		return null;
	}

	public Object visit(ASTdisplayStatement node, Object data) {
		return null;
	}

	public Object visit(ASTendStatement node, Object data) {
		return null;
	}

	public Object visit(ASTgosubStatement node, Object data) {
		return null;
	}

	public Object visit(ASTreturnStatement node, Object data) {
		return null;
	}

	public Object visit(ASTgrStatement node, Object data) {
		return null;
	}

	public Object visit(ASTgotoStatement node, Object data) {
		return null;
	}

	public Object visit(ASTExpression node, Object data) {
		return null;
	}

	public Object visit(ASTIf node, Object data) {
		ASTExpression condition = (ASTExpression)node.children[0];
		if(node.children[1] instanceof ASTStatement) {

		}
		return null;
	}

	public Object visit(ASTinitStatement node, Object data) {
		return null;
	}

	public Object visit(ASTinputStatement node, Object data) {
		return null;
	}

	public Object visit(ASTletStatement node, Object data) {
		Node variable = node.children[0].jjtGetChild(0);
		Assignment assignment = new Assignment();
		if(variable instanceof ASTSimpleVariable) {
			assignment.setNature(Assignment.Nature.Variable);
			assignment.setName(getName((ASTName) variable.jjtGetChild(0)));
			assignment.setType(getNameType((ASTName) variable.jjtGetChild(0)));
			assignment.setExpression((ASTExpression)node.children[1]);
		}
		else if(variable instanceof ASTArray) {
			//todo : arrays, positions need to be introduced to assignment class for array assignments
			// ie : arr[0,3] = 0; //// atm only "arr" the name and "0" the expression are stored
			assignment.setNature(Assignment.Nature.Array);
			String name = getName((ASTName) variable.jjtGetChild(0));
			throw new RuntimeException("Not implemented");
		}
		else {
			throw new UnknownChildException(variable);
		}
		assignment.digest();
		top().push(assignment);
		return null;
	}

	private String getName(ASTName name) {
		if(name.children[0] instanceof ASTNumberIdentifier) {
			return ((ASTNumberIdentifier) name.children[0]).value;
		}
		else if(name.children[0] instanceof ASTStringIdentifier) {
			return ((ASTStringIdentifier) name.children[0]).value;
		}
		throw new UnknownChildException(name.children[0]);
	}

	private ASTName.NameType getNameType(ASTName name) {
		if(name.children[0] instanceof ASTNumberIdentifier) {
			return ASTName.NameType.Number;
		}
		else if(name.children[0] instanceof ASTStringIdentifier) {
			return ASTName.NameType.String;
		}
		throw new UnknownChildException(name.children[0]);
	}

	public Object visit(ASTlineStatement node, Object data) {
		return null;
	}

	public Object visit(ASTlistStatement node, Object data) {
		return null;
	}

	public Object visit(ASTnewStatement node, Object data) {
		return null;
	}

	public Object visit(ASTonStatement node, Object data) {
		return null;
	}

	public Object visit(ASTpageStatement node, Object data) {
		return null;
	}

	public Object visit(ASTreadStatement node, Object data) {
		return null;
	}

	public Object visit(ASTdataStatement node, Object data) {
		return null;
	}

	public Object visit(ASTrestoreStatement node, Object data) {
		return null;
	}

	public Object visit(ASTrunStatement node, Object data) {
		return null;
	}

	public Object visit(ASTscreenStatement node, Object data) {
		return null;
	}

	public Object visit(ASTscrollStatement node, Object data) {
		return null;
	}

	public Object visit(ASTsoundStatement node, Object data) {
		return null;
	}

	public Object visit(ASTstopStatement node, Object data) {
		return null;
	}

	public Object visit(ASTstoreStatement node, Object data) {
		return null;
	}

	public Object visit(ASTtxStatement node, Object data) {
		return null;
	}

	public Object visit(ASTforLoopStatement node, Object data) {
		String var = getName((ASTName)node.children[0].jjtGetChild(0).jjtGetChild(0));
		ASTExpression initial = (ASTExpression)node.children[1];
		ASTExpression boundary = (ASTExpression)node.children[2];
		ASTExpression step = node.children.length > 3 ? (ASTExpression)node.children[3] : null;

		Loop loop = new Loop(initial, boundary, step, var);
		top().push(loop);
		containerStack.push(loop);
		return null;
	}

	public Object visit(ASTnextStatement node, Object data) {
		containerStack.pop();
		return null;
	}

	public Object visit(ASTprintStatement node, Object data) {
		return null;
	}

	public Object visit(ASTprintText node, Object data) {
		return null;
	}

	public Object visit(ASTStringLiteral node, Object data) {
		return null;
	}




	/*

	   public Object visit(ASTPrimaryPrefix node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTPrimaryExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }


	   public Object visit(ASTExponentialExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
	   }

	   public Object visit(ASTMultiplicativeExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTAdditiveExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTRelationalExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTComparisonExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTLogicalAndExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
   }

	   public Object visit(ASTLogicalOrExpression node, Object data) {
		   node.childrenAccept(this,data);
	   return null;
	   }*/

		private ConstructContainer top() {
			return containerStack.peek();
		}
}