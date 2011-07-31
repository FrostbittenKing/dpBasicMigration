package translation.emu;

import translation.MultiNumber;
import translation.NameType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import basicparser.programflow.Return;


public class BasicEmu {
	private static BasicEmu instance;

	private Random random = new Random(System.currentTimeMillis());

	private double lastRnd;
	private int printCharCounter;
	private String printText;
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
		printText = "";
	}

	public void print(String printText){
		printCharCounter += printText.length();
		this.printText += printText;
	}

	public void print(MultiNumber multiNumber) {
		printCharCounter += multiNumber.toString().length();
		this.printText += multiNumber.toString();
	}

	public static Object initializeNumberArray(MultiNumber ...multiNumbers) {

		int [] dimensions = new int[multiNumbers.length];
		for (int i = 0;i < dimensions.length; i++) {
			dimensions[i] = multiNumbers[i].getIntegerValue();
		}


		Object returnArray =  Array.newInstance(MultiNumber.class, dimensions);
		return instantiateArray(returnArray, NameType.Number);

	}
	
	public static Object initializeStringArray(MultiNumber ...multiNumbers) {

		int [] dimensions = new int[multiNumbers.length];
		for (int i = 0;i < dimensions.length; i++) {
			dimensions[i] = multiNumbers[i].getIntegerValue();
		}


		Object returnArray =  Array.newInstance(String.class, dimensions);
		return instantiateArray(returnArray, NameType.String);

	}
	

	private static Object instantiateArray(Object array, NameType type) {
		if (array != null && array.getClass().isArray()) {
			int length = Array.getLength(array);
			for (int i = 0; i < length; i++) {
				Object arrayElement = Array.get(array, i);
				instantiateArray(arrayElement,type);
				if (array != null && arrayElement == null) {
					switch (type) {
					case Number:
						Array.set(array, i, new MultiNumber());
						break;
						
					case String:
						Array.set(array, i, new String(""));
					}
				}
			}

		}
		return array;
	}


	public void endPrint(){
		System.out.println(printText);
	}

	public static BasicEmu instance() {
		if(instance == null) {
			instance = new BasicEmu();
		}
		return instance;
	}
}
