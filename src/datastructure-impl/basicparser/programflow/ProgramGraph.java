package basicparser.programflow;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class ProgramGraph implements ConstructContainer {
	private Construct first;
	private LinkedList<Construct> heads = new LinkedList<Construct>();
	private LinkedList<Construct> returnHeads = new LinkedList<Construct>();
	public static final String RETURN_CALL_METHOD_NAME_STACK = "returnCallMethodNameStack";
	public static final String RETURN_METHOD_PREFIX = "return_";
	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

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
		out.write(translateBy(first).getBytes());
	}

	public String translateBy(Construct child) {
		if(heads.contains(child)) {
			heads.remove(child);
		}
		heads.addFirst(child);

		String header =
				"import java.util.Stack;" + LINE_SEPARATOR +
				"import translation.MultiNumber;" + LINE_SEPARATOR +
				"import translation.BasicEmu;" + LINE_SEPARATOR + 
				LINE_SEPARATOR +
				"public class Main {" + LINE_SEPARATOR +
				"\tprivate static Main instance;" + LINE_SEPARATOR +
				"\t" + LINE_SEPARATOR +
				"\tpublic static void main(String[] args) {" + LINE_SEPARATOR +
				"\t\twhile(true) {" + LINE_SEPARATOR +
				"\t\t\ttry {" + LINE_SEPARATOR +
				"\t\t\t\tinstance().getClass().getDeclaredMethod(instance().nextCallMethodName).invoke(instance());" + LINE_SEPARATOR +
				"\t\t\t}" + LINE_SEPARATOR +
				"\t\t\tcatch(Exception e) {" + LINE_SEPARATOR +
				"\t\t\t\tthrow new RuntimeException(\"Method invocation error \" + e);" + LINE_SEPARATOR +
				"\t\t\t}" + LINE_SEPARATOR +
				"\t\t}" + LINE_SEPARATOR +
				"\t}" + LINE_SEPARATOR +
				LINE_SEPARATOR +
				"\tprivate static Main instance() {" + LINE_SEPARATOR +
				"\t\tif(instance == null) {" + LINE_SEPARATOR +
				"\t\t\tinstance = new Main();" + LINE_SEPARATOR +
				"\t\t}" + LINE_SEPARATOR +
				"\t\treturn instance;" + LINE_SEPARATOR +
				"\t}" + LINE_SEPARATOR;
		String nextMethodCallNameDecl = "private String " + makeNextCallMethodNameAssignment(getGoMethodFromLabel(heads.getFirst().getLabel())) + LINE_SEPARATOR;
		String returnCallMethodNameStackDecl = "private Stack<String> returnCallMethodNameStack = new Stack<String>();";
		String footer =
				"   }" + LINE_SEPARATOR;

		String result = "";

		result += header;
		result += VariableTable.instance().translate();

		Iterator<Construct> headIterator = heads.iterator();
		for(Construct head : heads) {
			result += translateMethod("private void " + getGoMethodFromLabel(head.getLabel()) + "()", head);
		}
		for(Construct head : returnHeads) {
			result += translateMethod("private void " + getReturnMethodFromLabel(head.getLabel()) + "()", head);
		}
		result += nextMethodCallNameDecl + LINE_SEPARATOR;
		result += returnCallMethodNameStackDecl + LINE_SEPARATOR;
		result += footer;
		return result;
	}

	private String translateMethod(String header, Construct head) {
		String result = "";
		result += header + "{" + LINE_SEPARATOR;
		Construct next = head;
		//if the construct we are translating is nested in a construct container we have to construct the
		//method from the construct container starting by the child
		if(head.hasTop()) {
			result += head.getTop().translateBy(head);
			next = ((Construct)head.getTop()).getNext();
		}
		for(Construct c = next; c != null; c = c.getNext()) {
			result += c.translate() + LINE_SEPARATOR;
			if(c instanceof Goto || c instanceof Gosub || c instanceof End) {
				break;
			}
		}
		result += "}" + LINE_SEPARATOR;
		return result;
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