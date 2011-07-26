package basicparser.programflow;

public class Goto extends Construct {
	public String translate() {
		String result = ProgramGraph.makeNextCallMethodNameAssignment(ProgramGraph.getGotoMethodFromLabel(this.getNext().getLabel())) + "\r\n";
		result += "return;";
		return result;
	}
}
