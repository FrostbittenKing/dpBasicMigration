package basicparser.programflow;

public class Cos extends Instruction{
	private Double value;
	private String varName;
	
	public Cos(Double value){
		this.value = value;
	}
	
	public Cos(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.cos(" + value + ");\r\n";
		}
		else {
			return "Math.cos(" + varName + ");\r\n";
		}
	}
}