package basicparser.programflow;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import basicparser.ASTExpression;
import basicparser.ASTName.NameType;

public class VariableTable {
	private LinkedList<String> strings = new LinkedList<String>();
	private LinkedList<String> numbers = new LinkedList<String>();
	private HashMap<String, LinkedList<String>> stringArrays = new HashMap<String, LinkedList<String>>();
	private HashMap<String, LinkedList<String>> numberArrays = new HashMap<String, LinkedList<String>>();

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

	public HashMap<String, LinkedList<String>> getStringArrays() {
		return stringArrays;
	}

	public HashMap<String, LinkedList<String>> getNumberArrays() {
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

		for(Map.Entry<String, LinkedList<String>> strArray : stringArrays.entrySet()) {
			result += "static String";
			for(int i = 0; i < strArray.getValue().size(); i++) {
				result += "[]";
			}
			
			result += " " + strArray.getKey() + " = (String ";
			

			for(int i = 0; i < strArray.getValue().size(); i++) {
				result += "[]";
			}
			
			result += ")"+ "BasicEmu.initializeStringArray(";
			
			
			for (int i = 0; i < strArray.getValue().size(); i++) {
				result += strArray.getValue().get(i) + ",";
			}
			result = result.substring(0, result.length() - 1) + ");" + LINE_SEPARATOR;
			
		}

		for(Map.Entry<String, LinkedList<String>> numArray : numberArrays.entrySet()) {
			result += "static MultiNumber";
			for(int i = 0; i < numArray.getValue().size(); i++) {
				result += "[]";
			}
			result += " " + numArray.getKey() + " = (MultiNumber ";
			
			for(int i = 0; i < numArray.getValue().size(); i++) {
				result += "[]";
			}
			
			result += ")" + "BasicEmu.initializeNumberArray(";
			
			for (int i = 0; i < numArray.getValue().size(); i++) {
				result += numArray.getValue().get(i) + ",";
			}
			result = result.substring(0, result.length() - 1) + ");" + LINE_SEPARATOR;
			
		}

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