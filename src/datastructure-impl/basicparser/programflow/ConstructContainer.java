package basicparser.programflow;

public interface ConstructContainer {
	public void push(Construct construct);
	public String translateBy(Construct child);
	public Construct getFirst();
}
