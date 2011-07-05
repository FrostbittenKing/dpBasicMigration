package programflow;

import programflow.MultiNumber;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;

public class VariableTable {
	private HashMap<String, StringBuffer> strings = new HashMap<String, StringBuffer>();
	private HashMap<String, MultiNumber> numbers = new HashMap<String, MultiNumber>();

	public HashMap<String, StringBuffer> getStrings() {
		return strings;
	}

	public HashMap<String, MultiNumber> getNumbers() {
		return numbers;
	}

	public static VariableTable instance() {
		if(instance == null) {
			instance = new VariableTable();
		}
		return instance;
	}

	private static VariableTable instance;
}