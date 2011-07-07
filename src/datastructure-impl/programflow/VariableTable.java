
package programflow;

import programflow.MultiNumber;

import java.lang.String;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.LinkedList;

public class VariableTable {
	private HashMap<String, StringBuffer> strings = new HashMap<String, StringBuffer>();
	private HashMap<String, MultiNumber> numbers = new HashMap<String, MultiNumber>();
        private HashMap<String, LinkedList<StringBuffer>> stringArrays = new HashMap<String, LinkedList<StringBuffer>>();
        private HashMap<String, LinkedList<String>> numberArrays = new HashMap<String, LinkedList<String>>();

	public HashMap<String, StringBuffer> getStrings() {
		return strings;
	}

	public HashMap<String, MultiNumber> getNumbers() {
		return numbers;
	}

        public HashMap<String, LinkedList<StringBuffer>> getStringArrays() {
	    return stringArrays;
	}

        public HashMap<String, LinkedList<String>> getNumberArrays() {
	    return numberArrays;
	}

	public static VariableTable instance() {
		if(instance == null) {
			instance = new VariableTable();
		}
		return instance;
	}

	private static VariableTable instance;
}