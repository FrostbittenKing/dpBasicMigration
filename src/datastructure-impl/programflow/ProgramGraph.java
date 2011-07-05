package programflow;

import java.lang.Object;

public class ProgramGraph {
	private Sequence sequence = new Sequence();

	public Construct getConstruct(int label) {
		for(Construct construct : sequence.getConstructs()) {
			if(construct.getLabel() == label) {
				return construct;
			}
		}
		return null;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public ProgramGraph instance() {
		if(instance == null) {
			instance = new ProgramGraph();
		}
		return instance;
	}

	private static ProgramGraph instance;
}