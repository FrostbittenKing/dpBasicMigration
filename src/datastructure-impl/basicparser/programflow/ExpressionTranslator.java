package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.BasicVisitor;
import basicparser.JJTBasicParserState;
import basicparser.SimpleNode;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;

public class ExpressionTranslator {
	public String translate(ASTExpression expression) {
		//todo eugen
		String javaExpression = new String();
		ExpressionVisitor exp = new ExpressionVisitor();
		javaExpression = build((SimpleNode)expression.jjtGetChild(0),exp);
		return javaExpression;
	}


	public static ExpressionTranslator instance() {
		if(instance == null) {
			instance = new ExpressionTranslator();
		}
		return instance;
	}



	private static ExpressionTranslator instance;
	private String build(SimpleNode node, ExpressionVisitor visitor) {
		String[] javaExpression;	
		String returnVal = new String();
		/*		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode)node.jjtGetChild(i);
			javaExpression += build(child, visitor);

		}
		String tempval = (String)node.jjtAccept(visitor,null);
		if (tempval != null) {
			javaExpression += tempval;
		}*/
		while (node.jjtGetNumChildren() == 1) {
			node = (SimpleNode)node.jjtGetChild(0);
		}

		javaExpression = new String[node.jjtGetNumChildren()];
		for (int i = 0; i < javaExpression.length; i++) {
			javaExpression[i] = "";
		}

		if (node.jjtGetNumChildren() >= 2) {
			for (int i = 0; i < javaExpression.length; i++) {
				javaExpression[i] += build((SimpleNode)node.jjtGetChild(i),visitor);
			}
			returnVal = (String)node.jjtAccept(visitor,javaExpression);
		}
		else {
			String tempval = (String)node.jjtAccept(visitor,null);
			if (tempval != null) {
				returnVal += tempval;
			}
		}
		return returnVal;
	}
}