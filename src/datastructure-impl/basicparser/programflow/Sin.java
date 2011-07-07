package basicparser.programflow;

public class Sin extends Instruction{
	private Double value;
	private String varName;
	
	public Sin(Double value){
		this.value = value;
	}
	
	public Sin(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.sin(" + value + ");\r\n";
		}
		else {
			return "Math.sin(" + varName + ");\r\n";
	
		}
	}
}