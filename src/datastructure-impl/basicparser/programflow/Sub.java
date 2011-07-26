package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.programflow.ProgramGraph;

import java.lang.String;

public class Sub extends Construct implements ConstructContainer {
	private Construct first = null;

	public void push(Construct construct) {
		if(first == null) {
			first = construct;
		}
		else {
			Construct c;
			for(c = first; c.getNext() != null; c = c.getNext()) ;
			c.setNext(construct);
		}
	}

	public Construct getFirst() {
		return first;
	}

	public String translate() {
		String result =
				"private void " + ProgramGraph.getGosubMethodFromLabel(first.getLabel()) + "() {\r\n";
		for(Construct c = first; !(c instanceof Return); c = c.getNext()) {
			result += c.translate() + "\r\n";
		}
		result += "}\r\n";
		return result;
	}
}