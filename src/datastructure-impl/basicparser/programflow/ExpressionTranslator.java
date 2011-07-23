package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.BasicVisitor;
import basicparser.SimpleNode;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;

public class ExpressionTranslator {
	public String translate(ASTExpression expression) {
		//todo eugen
		build(expression,null);
		return "";
	}


	public static ExpressionTranslator instance() {
		if(instance == null) {
			instance = new ExpressionTranslator();
		}
		return instance;
	}
	
	

	private static ExpressionTranslator instance;
	
	private void build(SimpleNode node, ExpressionVisitor visitor) {
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode)node.jjtGetChild(i);
			build(child, visitor);
			node.jjtAccept(visitor, null);
		}
	}
}