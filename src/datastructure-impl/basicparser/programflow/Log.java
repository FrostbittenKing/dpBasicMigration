package basicparser.programflow;

public class Log extends Instruction{
	private Double value;
	private String varName;
	
	public Log(Double value){
		this.value = value;
	}
	
	public Log(String varName){
		this.varName = varName;
	}
	
	@Override
	public String translate(){
		if(value != null){
			return "Math.log(" + value + ");\r\n";
		}
		else {
			return "Math.log(" + varName + ");\r\n";
		}
	}
}