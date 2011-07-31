package basicparser;

import basicparser.programflow.ProgramGraph;
import basicparser.SimpleNode;
import basicparser.programflow.GraphBuilder;
import java.io.*;

/** Simple brace matcher. */
public class BasicParser {

	/**
	 * Main entry point.
	 */
	private static final String GENERATION_DIRECTORY = "java-translation";
	private static final String OUTPUT_FILENAME = "Main.java";
	
	public static void main(String args[]) throws ParseException, FileNotFoundException, IOException {
		InputStream instream = args.length == 0 ? System.in : new FileInputStream(args[0]);
		
		try {
		    SimpleNode root = pass1(instream);
			ProgramGraph graph = pass2(root);
			
			
			File f = new java.io.File(GENERATION_DIRECTORY);
			if (!f.exists()) {
				if (!f.mkdirs()) {
					throw new Exception("directory couldn't be created");
				}
			}
			f = new java.io.File(GENERATION_DIRECTORY + File.separator + OUTPUT_FILENAME);
			f.createNewFile();
			pass3(graph, new FileOutputStream(f));
		}
		catch(Exception e) {
			System.out.println("Oops.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static SimpleNode pass1(InputStream instream) throws ParseException {
		BasicParserGEN parser = new BasicParserGEN(instream);
		ASTparseRoot r = parser.parseRoot();
		r.dump(">");
		return r;
	}

	public static ProgramGraph pass2(SimpleNode root) throws ParseException {
		GraphBuilder builder = new GraphBuilder();
		return builder.build(root);
	}

	public static void pass3(ProgramGraph graph, OutputStream out) throws IOException {
		System.out.println("<<<JAVA>>>");
		graph.translate(out);
	}
}
