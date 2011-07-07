package basicparser.programflow;

import java.lang.Object;

public class ProgramGraph {
	private Construct first;

	public ProgramGraph instance() {
		if(instance == null) {
			instance = new ProgramGraph();
		}
		return instance;
	}

	private static ProgramGraph instance;
}