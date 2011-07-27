package basicparser.programflow;

/**
 * while building the graph the next pointer of the goto points to the successor instruction of the goto ("geographic" next),
 * after the goto's are re-linked by the graph builder the next pointer points to the semantic target of the goto
 */
public class Goto extends Construct {
	public String translate() {
		String result =
				ProgramGraph.makeNextCallMethodNameAssignment(ProgramGraph.getGoMethodFromLabel(this.getNext().getLabel())) + "\r\n" +
				"return;";
		return result;
	}
}
