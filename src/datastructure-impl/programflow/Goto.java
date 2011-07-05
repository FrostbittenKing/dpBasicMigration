package programflow;

public class Goto extends Construct {
	private Construct target;

	public Goto(Construct target) {
		this.target = target;
	}

	public Construct getTarget() {
		return target;
	}

	public String translate() {
		return null;
	}
}
