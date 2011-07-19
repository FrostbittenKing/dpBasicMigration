package basicparser.programflow;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VariableTable {
	private LinkedList<String> strings = new LinkedList<String>();
	private LinkedList<String> numbers = new LinkedList<String>();
	private HashMap<String, LinkedList<Integer>> stringArrays = new HashMap<String, LinkedList<Integer>>();
	private HashMap<String, LinkedList<Integer>> numberArrays = new HashMap<String, LinkedList<Integer>>();

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

//	MultiNumber[][][] x = {{new MultiNumber(0), new MultiNumber(0)}, {new MultiNumber(0)}};

	public String translate() {
		String result = "";
		for(String string : strings) {
			result += "String " + string + " = \"\";\r\n";
		}
		for(String number : numbers) {
			result += "MultiNumber " + number + " = new MultiNumber();\r\n";
		}
		//todo: arrays
//		for(Map.Entry<String, LinkedList<Integer>> strArray : stringArrays.entrySet()) {
//			result += "String";
//			for(int i = 0; i < strArray.getValue().size(); i++) {
//				result += "[]";
//			}
//			result += strArray.getKey() + " {";
//			for(Integer integer : strArray.getValue()) {
//				for(int i = 0; i < integer; i++) {
//					result += "[]";
//				}
//			}
//			//remove last ,
//			result = result.substring(0, result.length() - 1);
//			result += "];\r\n";
//		}

		return result;
	}

	public static VariableTable instance() {
		if(instance == null) {
			instance = new VariableTable();
		}
		return instance;
	}

	private static VariableTable instance;
}