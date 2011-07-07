package basicparser.programflow;

public class Abs extends Instruction{
	private Double value;
	private String varName;
	
	public Abs(Double value){
		this.value = value;
	}
	
	public Abs(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.abs(" + value + ");\r\n";
		}
		else {
			return "Math.abs(" + varName + ");\r\n";
		}
	}
}