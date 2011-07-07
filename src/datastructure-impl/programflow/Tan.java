package programflow;

public class Tan extends Instruction{
	private Double value;
	private String varName;
	
	public Tan(Double value){
		this.value = value;
	}
	
	public Tan(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.tan(" + value + ");\r\n";
		}
		else {
			return "Math.tan(" + varName + ");\r\n";
		}
	}
}