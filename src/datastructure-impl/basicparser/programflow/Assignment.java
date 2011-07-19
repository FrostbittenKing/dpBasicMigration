package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.ASTName;
import basicparser.programflow.ExpressionTranslator;

import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuffer;
import java.util.LinkedList;

public class Assignment extends Instruction{
	private ASTName.NameType type;
	private Nature nature;
	private String name;
	private ASTExpression expression;

	public void digest() {
		switch(nature) {
			case Array:
				switch(type) {
					case Number:
						if(VariableTable.instance().contains(name) && !VariableTable.instance().getNumberArrays().containsKey(name)) {
							throw new RuntimeException("Variable name not unique to number arrays : " + name);
						}
						break;
					case String:
						if(VariableTable.instance().contains(name) && !VariableTable.instance().getStringArrays().containsKey(name)) {
							throw new RuntimeException("Variable name not unique to string arrays: " + name);
						}
						break;
					default:
						throw new RuntimeException("Unknown type " + type);
				}
				break;
			case Variable:
				switch(type) {
					case Number:
						if(VariableTable.instance().contains(name) && !VariableTable.instance().getNumbers().contains(name)) {
							throw new RuntimeException("Variable name not unique to number variables : " + name);
						}
						VariableTable.instance().getNumbers().add(name);
						break;
					case String:
						if(VariableTable.instance().contains(name) && !VariableTable.instance().getStrings().contains(name)) {
							throw new RuntimeException("Variable name not unique to string variables: " + name);
						}
						VariableTable.instance().getStrings().add(name);
						break;
					default:
						throw new RuntimeException("Unknown type " + type);
				}
				break;
			default:
				throw new RuntimeException("Unknown nature " + nature);
		}
	}

	public ASTExpression getExpression() {
		return expression;
	}

	public void setExpression(ASTExpression expression) {
		this.expression = expression;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ASTName.NameType getType() {
		return type;
	}

	public void setType(ASTName.NameType type) {
		this.type = type;
	}

	@Override
	public String translate(){
		return name + " = " + ExpressionTranslator.instance().translate(expression) + ";";
	}

	public static enum Nature {
		Array,
		Variable
	}
}