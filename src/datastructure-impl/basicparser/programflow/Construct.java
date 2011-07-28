package basicparser.programflow;

import basicparser.programflow.ConstructContainer;

public abstract class Construct {
	private int label;
	private Construct next = null;
	private ConstructContainer top;

	public abstract String translate();

	public Construct getNext() {
		return next;
	}

	public void setNext(Construct next) {
		this.next = next;
	}

	public void setTop(ConstructContainer top) {
		this.top = top;
	}

	public ConstructContainer getTop() {
		return top;
	}

	public boolean hasTop() {
		return top != null;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
}