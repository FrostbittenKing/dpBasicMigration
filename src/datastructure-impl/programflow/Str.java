package programflow;

public class Str extends Instruction{
	private Double value;
	
	public Str(Double value){
		this.value = value;
	}
	
	@Override
	public String translate(){
		return new Double(value).toString();
	}
}