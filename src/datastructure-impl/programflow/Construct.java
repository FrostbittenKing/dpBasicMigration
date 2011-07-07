package programflow;

public abstract class Construct {
	private int label;
	private Construct next;

	public abstract String translate();

	public Construct getNext() {
		return next;
	}

	public void setNext(programflow.Construct next) {
		this.next = next;
	}

	public int getLabel() {
		return label;
	}
}