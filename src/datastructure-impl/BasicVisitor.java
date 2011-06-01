import java.util.LinkedList;

public class BasicVisitor implements BasicParserVisitor {
    private LinkedList stack = new LinkedList();

    public Object visit(SimpleNode node, Object data) {
	node.childrenAccept(this,data);
	return null;
    }
    public Object visit(ASTparseRoot node, Object data) {
	node.childrenAccept(this,data);
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
    public Object visit(ASTArrayDeclaration node, Object data) {
	node.childrenAccept(this,data);
	while (!node.data.empty()) {
	    stack.add(node.data.pop());
	}
	return null;
    }
    public Object visit(ASTStringIdentifier node, Object data) {
	stack.add(node.data.pop());
	return null;
    }
    
    public Object visit(ASTNumberIdentifier node, Object data) {
	stack.add(node.data.pop());
	return null;
    }

    public Object visit(ASTStatement node, Object data) {
	node.childrenAccept(this,data);
	return null;
    }

    public Object visit(ASTDimStatement node, Object data) {
	node.childrenAccept(this,data);
	while (stack.size()>0) {
	    System.out.println(stack.getFirst());
	    stack.removeFirst();
	}
	return null;
    }
    
}