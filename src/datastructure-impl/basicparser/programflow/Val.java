package basicparser.programflow;

public class Val extends Instruction{
	private String varName;
	
	public Val(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		try {
			return "Double.parseDouble(" + varName + ");\r\n";
		}
		catch (NullPointerException e){
			return "0";
		}
		catch (NumberFormatException e){
			return "0";
		}
	}
}