package basicparser.programflow;

public class End extends Instruction{
	@Override
	public String translate(){
		return "System.exit(0);";
	}
}