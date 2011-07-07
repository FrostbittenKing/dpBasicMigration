package basicparser.programflow;

public class Sqr extends Instruction{
	private Double value;
	private String varName;
	
	public Sqr(Double value){
		this.value = value;
	}
	
	public Sqr(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.sqrt(" + value + ");\r\n";
		}
		else {
			return "Math.sqrt(" + varName + ");\r\n";
		}
	}
}