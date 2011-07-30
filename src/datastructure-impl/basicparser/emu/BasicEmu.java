package basicparser.emu;

import basicparser.ASTExpression;
import basicparser.programflow.MultiNumber;

import java.util.Random;

public class BasicEmu {
	private static BasicEmu instance;
	
	private Random random = new Random(System.currentTimeMillis());

	private double lastRnd;
	private int printCharCounter;
	public MultiNumber rnd(MultiNumber x) {
		if(x.getIntegerValue() == 0) {
			return new MultiNumber(lastRnd);
		}
		lastRnd = (double)random.nextInt(101) / 100;
		return new MultiNumber(lastRnd);
	}
	
	public String left(String string, MultiNumber endPosition){
		if (string == null || string.length() == 0){
			return "";
		}
		
		try{
			return string.substring(0, endPosition.getIntegerValue());
		}
		catch (IndexOutOfBoundsException e){
			return string;
		}
	}
	
	public String right(String string, MultiNumber startPosition){
		if (startPosition.getIntegerValue() == 0){
			return "";
		}
		try{
			return string.substring(startPosition.getIntegerValue());
		}
		catch (IndexOutOfBoundsException e){
			return string;
		}
	}

	public String mid(String string, MultiNumber startPosition, MultiNumber characterCount){
		if (startPosition.getIntegerValue() == 0){
			return "";
		}
		if (characterCount == null || startPosition.getIntegerValue() + characterCount.getIntegerValue() > string.length()){
			return string.substring(startPosition.getIntegerValue());
		}
		else{
			return string.substring(startPosition.getIntegerValue(), startPosition.getIntegerValue() + characterCount.getIntegerValue());
		}
	}
	
	public String chr(MultiNumber character){
		return new String(Character.toChars(character.getIntegerValue()));
	}
	
	public MultiNumber strToNum(String input){
		MultiNumber returnValue = null;
		try {
			returnValue = new MultiNumber(Double.parseDouble(input));
		}
		catch (Exception e){
			returnValue = new MultiNumber(0.0);
		}
		return returnValue;
	}
	
	public String spc(MultiNumber spaceCount){
		String returnString = "";
		for (int i = 0; i < spaceCount.getIntegerValue(); i++){
			returnString += " ";
		}
		return returnString;
	}
	
	public String tab(MultiNumber tabCount){
		
		if (tabCount.getIntegerValue() - printCharCounter <= 0){
			return "";
		}
		return spc(new MultiNumber(tabCount.getIntegerValue() - printCharCounter));
	}
	
	public MultiNumber asc(String string){
		if (string == null || string.equals("")){
			throw new RuntimeException("Tried calling asc with empty argument");
		}
		return new MultiNumber(Character.getNumericValue(string.charAt(0)));
	}
	
	public void startPrint(){
		printCharCounter = 0;
	}
	
	public void print(){
		
	}
	
	
	
	public void endPrint(){
		
	}

	public static BasicEmu instance() {
		if(instance == null) {
			instance = new BasicEmu();
		}
		return instance;
	}
}
