package basicparser.programflow;

public class Goto extends Construct {
	public String translate() {
		return ProgramGraph.getMethodFromLabel(this.getNext().getLabel()) + "();";
	}
}
