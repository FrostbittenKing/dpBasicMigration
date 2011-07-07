package basicparser.programflow;

public class Exp extends Instruction{
	private Double value;
	private String varName;
	
	public Exp(Double value){
		this.value = value;
	}
	
	public Exp(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.pow(Math.E, " + value + ");\r\n";
		}
		else {
			return "Math.pow(Math.E, " + varName + ");\r\n";
		}
	}
}