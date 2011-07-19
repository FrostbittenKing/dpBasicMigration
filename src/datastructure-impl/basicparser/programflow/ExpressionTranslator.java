package basicparser.programflow;

import basicparser.ASTExpression;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;

public class ExpressionTranslator {
	public String translate(ASTExpression expression) {
		//todo eugen
		return "";
	}

	public static ExpressionTranslator instance() {
		if(instance == null) {
			instance = new ExpressionTranslator();
		}
		return instance;
	}

	private static ExpressionTranslator instance;
}