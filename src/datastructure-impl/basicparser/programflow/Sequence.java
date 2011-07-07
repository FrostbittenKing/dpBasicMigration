package basicparser.programflow;

import java.lang.Object;
import java.util.ArrayList;

public class Sequence extends Construct {
	private ArrayList<Construct> constructs = new ArrayList<Construct>();

	public String translate() {
		String result = "";
		for(Construct construct : constructs) {
			result += construct.translate() + "\r\n";
		}
		return result;
	}

	public ArrayList<Construct> getConstructs() {
		return constructs;
	}
}