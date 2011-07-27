package basicparser.programflow;

import basicparser.programflow.Assignment;
import basicparser.programflow.Construct;
import basicparser.programflow.End;
import basicparser.programflow.Gosub;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Character;
import java.lang.Object;
import java.util.Iterator;
import java.util.LinkedList;

public class ProgramGraph implements ConstructContainer {
	private Construct first;
	private LinkedList<Construct> heads = new LinkedList<Construct>();
	private LinkedList<Construct> returnHeads = new LinkedList<Construct>();
	private LinkedList<Sub> subs = new LinkedList<Sub>();
	public static final String RETURN_CALL_METHOD_NAME_STACK = "returnCallMethodNameStack";
	public static final String RETURN_METHOD_PREFIX = "return_";

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

	/**
	 * make the last node an end node if it isn't
	 */
	public void finalize() {
		if(first == null) {
			first = new End();
			return;
		}
		Construct c;
		for(c = first; c.getNext() != null; c = c.getNext()) ;
		c.setNext(new End());
	}

	public Construct getFirst() {
		return first;
	}

	public Construct getConstructByLabel(int label) {
		return getConstructByLabel(first, label);
	}

	private Construct getConstructByLabel(Construct head, int label) {
		for(Construct c = head; c != null; c = c.getNext()) {
			if(c.getLabel() == label) {
				return c;
			}
			if(c instanceof ConstructContainer) {
				Construct result = getConstructByLabel(((ConstructContainer) c).getFirst(), label);
				if(result != null) {
					return result;
				}
			}
		}
		return null;
	}

	/**
	 * heads are constructs which have a goto pointing to them and thus make up the start of a new method
	 * the first head is always the first instruction in the program, even if no goto is pointing to it
	 * and acts as the first statement of the main method
	 *
	 * @return function head constructs (first construct in function)
	 */
	public LinkedList<Construct> getHeads() {
		return heads;
	}

	/**
	 * heads are constructs which have a return pointing to them and thus make up the start of a new method
	 *
	 * @return return-resulting function head constructs (first construct in function)
	 */
	public LinkedList<Construct> getReturnHeads() {
		return returnHeads;
	}

	public void translate(OutputStream out) throws IOException {
		String header =
				"import java.util.Stack;\n" +
				"\n" +
				"public class Main {\n" +
				"\tprivate static Main instance;\n" +
				"\t\n" +
				"\tpublic static void main(String[] args) {\n" +
				"\t\twhile(true) {\n" +
				"\t\t\ttry {\n" +
				"\t\t\t\tinstance().getClass().getDeclaredMethod(instance().nextCallMethodName).invoke(instance());\n" +
				"\t\t\t}\n" +
				"\t\t\tcatch(Exception e) {\n" +
				"\t\t\t\tthrow new RuntimeException(\"Method invocation error \" + e);\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t}\n" +
				"\n" +
				"\tprivate static Main instance() {\n" +
				"\t\tif(instance == null) {\n" +
				"\t\t\tinstance = new Main();\n" +
				"\t\t}\n" +
				"\t\treturn instance;\n" +
				"\t}\r\n";
		String nextMethodCallNameDecl = "private String " + makeNextCallMethodNameAssignment(getGoMethodFromLabel(heads.getFirst().getLabel())) + "\r\n";
		String returnCallMethodNameStackDecl = "private Stack<String> returnCallMethodNameStack = new Stack<String>();";
		String footer =
				"   }\r\n";

		out.write(header.getBytes());
		out.write(VariableTable.instance().translate().getBytes());

		Iterator<Construct> headIterator = heads.iterator();
		for(Construct head : heads) {
			translateMethod("private void " + getGoMethodFromLabel(head.getLabel()) + "()", head, out);
		}
		for(Construct head : returnHeads) {
			translateMethod("private void " + getReturnMethodFromLabel(head.getLabel()) + "()", head, out);
		}
		out.write((nextMethodCallNameDecl + "\r\n").getBytes());
		out.write((returnCallMethodNameStackDecl + "\r\n").getBytes());
		out.write(footer.getBytes());
	}

	private void translateMethod(String header, Construct head, OutputStream out) throws IOException {
		out.write((header + "{\r\n").getBytes());
		for(Construct c = head; c != null; c = c.getNext()) {
			out.write((c.translate() + "\r\n").getBytes());
			if(c instanceof Goto || c instanceof Gosub) {
				break;
			}
		}
		out.write("}\r\n".getBytes());
	}

	public static String makeNextCallMethodNameAssignment(String method) {
		return "nextCallMethodName = \"" + method + "\";";
	}

	public static String getReturnMethodFromLabel(int label) {
		return "return_" + label;
	}

	public static String getGoMethodFromLabel(int label) {
		return "go_" + label;
	}
}