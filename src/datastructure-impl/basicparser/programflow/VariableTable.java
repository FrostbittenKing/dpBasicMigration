package basicparser.programflow;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import basicparser.ASTName.NameType;

public class VariableTable {
	private LinkedList<String> strings = new LinkedList<String>();
	private LinkedList<String> numbers = new LinkedList<String>();
	private HashMap<String, LinkedList<Integer>> stringArrays = new HashMap<String, LinkedList<Integer>>();
	private HashMap<String, LinkedList<Integer>> numberArrays = new HashMap<String, LinkedList<Integer>>();

	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

	
	public boolean contains(String name) {
		return strings.contains(name) || numbers.contains(name) || stringArrays.containsKey(name) || numberArrays.containsKey(name);
	}

	public LinkedList<String> getStrings() {
		return strings;
	}

	public LinkedList<String> getNumbers() {
		return numbers;
	}

	public HashMap<String, LinkedList<Integer>> getStringArrays() {
		return stringArrays;
	}

	public HashMap<String, LinkedList<Integer>> getNumberArrays() {
		return numberArrays;
	}

	public String translate() {
		String result = "";
		for(String string : strings) {
			result += "static String " + string + " = \"\";" + LINE_SEPARATOR;
		}
		for(String number : numbers) {
			result += "static MultiNumber " + number + " = new MultiNumber();" + LINE_SEPARATOR;
		}

		for(Map.Entry<String, LinkedList<Integer>> strArray : stringArrays.entrySet()) {
			result += "static String";
			for(int i = 0; i < strArray.getValue().size(); i++) {
				result += "[]";
			} //number of dimensions

			result += " " + strArray.getKey() + " = {"; //variable name + = + opening brace

			result += instantiateArray(strArray.getValue(), 1, NameType.String);
			result += "};" + LINE_SEPARATOR;
		}

		for(Map.Entry<String, LinkedList<Integer>> numArray : numberArrays.entrySet()) {
			result += "static MultiNumber";
			for(int i = 0; i < numArray.getValue().size(); i++) {
				result += "[]";
			} //number of dimensions

			result += " " + numArray.getKey() + " = {"; //variable name + = + opening brace

			result += instantiateArray(numArray.getValue(), 1, NameType.Number);
			result += "};" + LINE_SEPARATOR;
		}

		return result;
	}

	private String instantiateArray(LinkedList<Integer> dimensions, int index, NameType type) {
		String returnString = "";
		if(index == dimensions.size()) {
			for(int i = 0; i < dimensions.get(index-1); i++) {
				switch (type){
					case String:
						returnString += "\"\",";
					break;
					case Number:
						returnString += "new MultiNumber(),";
					break;
				}
			}
			return returnString.substring(0, returnString.length()-1);
		}

		for(int i = 0; i < dimensions.get(index-1); i++) {
			returnString += "{" + instantiateArray(dimensions, index+1, type) + "},";
		}
		return returnString.substring(0, returnString.length()-1);
	}

	public static VariableTable instance() {
		if(instance == null) {
			instance = new VariableTable();
		}
		return instance;
	}

	private static VariableTable instance;
}