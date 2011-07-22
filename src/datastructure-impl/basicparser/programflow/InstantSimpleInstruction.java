package basicparser.programflow;

import java.lang.String;

public class InstantSimpleInstruction extends Instruction{
	private String java;

	public InstantSimpleInstruction() {
	}

	public InstantSimpleInstruction(String java) {
		this.java = java;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	@Override
	public String translate(){
		System.out.println("TRANSLATE ISI");
		return java + "\r\n";
	}
}