package programflow;

public class Int extends Instruction{
	private Double value;
	private String varName;
	
	public Int(Double value){
		this.value = value;
	}
	
	public Int(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.ceil(" + value + ");\r\n";
		}
		else {
			return "Math.ceil(" + varName + ");\r\n";
		}
	}
}