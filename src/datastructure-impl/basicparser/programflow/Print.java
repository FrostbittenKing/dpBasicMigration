package basicparser.programflow;

public class Print extends Instruction{
	private String string;
	
	public Print(String string){
		this.string = string;
	}
	
	@Override
	public String translate(){
		return "System.out.println(\"" + string + "\");\r\n";
	}
}

