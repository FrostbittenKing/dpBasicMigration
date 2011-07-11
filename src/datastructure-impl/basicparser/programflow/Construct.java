package basicparser.programflow;

public abstract class Construct {
	private int label;
	private Construct next;

	public abstract String translate();

	public Construct getNext() {
		return next;
	}

	public void setNext(Construct next) {
		this.next = next;
	}

	public int getLabel() {
		return label;
	}
}