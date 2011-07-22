package basicparser.programflow;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Object;

public class ProgramGraph {
	private Construct first;

	public void push(Construct construct) {
		if(first == null) {
			first = construct;
		}
		else {
			Construct c;
			for(c = first; c.getNext() != null; c = c.getNext());
			c.setNext(construct);
		}
	}

	public ProgramGraph instance() {
		if(instance == null) {
			instance = new ProgramGraph();
		}
		return instance;
	}

	public void translate(OutputStream out) throws IOException {
		String header =
				"public class Main {\r\n" +
		        "   public static void main(String args[]) {\r\n" +
		        "       ";
		String footerMain =
				"   }\r\n";
		String footerClass =
				"}\r\n";
		out.write(header.getBytes());
		for(Construct c = first; c != null; c = c.getNext()) {
			out.write(c.translate().getBytes());
			out.write("\r\n".getBytes());
		}
		out.write(footerMain.getBytes());
		out.write(VariableTable.instance().translate().getBytes());
		out.write(footerClass.getBytes());
	}

	private static ProgramGraph instance;
}