package basicparser.programflow;

import java.util.Scanner;
import java.util.Vector;

import basicparser.ASTName;
import basicparser.ASTName.NameType;
import basicparser.programflow.Assignment.Nature;

public class Input extends Instruction {

	private String msg;
	private Vector<InputInformation> inputInformation = new Vector<Input.InputInformation>();
	public static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
	public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void digest() {
		for (InputInformation currentInputInformation : inputInformation) {
			switch(currentInputInformation.type) {
			case Number:
				if(VariableTable.instance().contains(currentInputInformation.name)) {
					if(!VariableTable.instance().getNumbers().contains(currentInputInformation.name)) {
						throw new RuntimeException("Variable name not unique to number variables : " + currentInputInformation.name);
					}
				}
				else {
					VariableTable.instance().getNumbers().add(currentInputInformation.name);
				}
				break;
			case String:
				if(VariableTable.instance().contains(currentInputInformation.name)) {
					if(!VariableTable.instance().getStrings().contains(currentInputInformation.name)) {
						throw new RuntimeException("Variable name not unique to string variables: " + currentInputInformation.name);
					}
				}
				else {
					VariableTable.instance().getStrings().add(currentInputInformation.name);
				}
				break;
			default:
				throw new RuntimeException("Unknown type " + currentInputInformation.type);
			}
		}
	}

	@Override
	public String translate() {
		String translatedString = new String("System.out.print(");
		if (msg != null) {
			translatedString += msg;
		}
		translatedString += " + \"?\");";
		translatedString += LINE_SEPARATOR;
		translatedString += "sc = new Scanner(System.in);" + LINE_SEPARATOR;
		translatedString += "sc.useDelimiter(\" *, *|";
		for (int i = 0; i < LINE_SEPARATOR.length(); i++) {
			if (LINE_SEPARATOR.charAt(i) == '\n') {
				translatedString += "\\n";
			}
			else if (LINE_SEPARATOR.charAt(i) == '\r') {
				translatedString += "\\r";
			}
		}
		translatedString += "\");" + LINE_SEPARATOR;

		for (InputInformation currentInputInformation : inputInformation) {
			switch(currentInputInformation.type) {
			case Number:
				translatedString += currentInputInformation.name + " = new MultiNumber(sc.next());" + LINE_SEPARATOR; 
				break;
			case String:
				translatedString += currentInputInformation.name + " = sc.next();" + LINE_SEPARATOR;
				break;
			default:
				throw new RuntimeException("Unknown type " + currentInputInformation.type);
			}
		}
		return translatedString;
	}


	public void addInputInformation(InputInformation info) {
		this.inputInformation.add(info);
	}

	public class InputInformation {
		private ASTName.NameType type;
		private String name;


		public InputInformation(ASTName.NameType type,  String name) {
			super();
			this.type = type;
			this.name = name;
		}

		public ASTName.NameType getType() {
			return type;
		}

		public void setType(ASTName.NameType type) {
			this.type = type;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


	}

}
