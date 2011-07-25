package basicparser.programflow;

import basicparser.programflow.Assignment;
import basicparser.programflow.Construct;
import basicparser.programflow.End;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Object;
import java.util.Iterator;
import java.util.LinkedList;

public class ProgramGraph implements ConstructContainer {
	private Construct first;
	private LinkedList<Construct> heads = new LinkedList<Construct>();

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
		for(c = first; c.getNext() != null; c = c.getNext());
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

	public void translate(OutputStream out) throws IOException {
		String header =
				"public class Main {\r\n";
		String footerMain =
				"   }\r\n";
		String footerClass =
				"}\r\n";
		out.write(header.getBytes());
		Iterator<Construct> headIterator = heads.iterator();
		translateMethod("public static void main(String[] args)", headIterator.next(), out);
		while(headIterator.hasNext()) {
			Construct head = headIterator.next();
			translateMethod("private static void " + getMethodFromLabel(head.getLabel()) + "()", head, out);
		}
		out.write(VariableTable.instance().translate().getBytes());
		out.write(footerClass.getBytes());
	}

	private void translateMethod(String header, Construct head, OutputStream out) throws IOException {
		out.write((header + "{\r\n").getBytes());
		for(Construct c = head; c != null; c = c.getNext()) {
			out.write((c.translate() + "\r\n").getBytes());
			if(c instanceof Goto) {
				break;
			}
		}
		out.write("}\r\n".getBytes());
	}

	public static String getMethodFromLabel(int label) {
		return "m_" + label;
	}
}