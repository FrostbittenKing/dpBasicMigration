package programflow;

public abstract class Construct {
	private int label;

	public abstract String translate();

	public int getLabel() {
		return label;
	}
}