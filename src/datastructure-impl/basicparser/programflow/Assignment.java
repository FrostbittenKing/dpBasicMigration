package basicparser.programflow;

import basicparser.ASTExpression;
import basicparser.ASTName;
import basicparser.programflow.ExpressionTranslator;

import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Assignment extends Instruction {
	private ASTName.NameType type;
	private Nature nature;
	private String name;
	private ASTExpression expression;
	private Vector<ASTExpression> positions;

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
				if(VariableTable.instance().contains(name)) {
					if(!VariableTable.instance().getNumbers().contains(name)) {
						throw new RuntimeException("Variable name not unique to number variables : " + name);
					}
				}
				else {
					VariableTable.instance().getNumbers().add(name);
				}
				break;
			case String:
				if(VariableTable.instance().contains(name)) {
					if(!VariableTable.instance().getStrings().contains(name)) {
						throw new RuntimeException("Variable name not unique to string variables: " + name);
					}
				}
				else {
					VariableTable.instance().getStrings().add(name);
				}
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

	public void setPositions(Vector<ASTExpression> pos) {
		this.positions = pos;
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
	public String translate() {
		switch (nature) {
		case Variable:
			switch(type) {
			case Number:
				return name + ".assign(" + ExpressionTranslator.instance().translate(expression) + ");";
			case String:
				return name + " = " + ExpressionTranslator.instance().translate(expression) + ";";
			default:
				break;
			}
			break;
		case Array:
			String returnString = name;
			
			switch (type) {
			case Number:
				for (ASTExpression currentPosition : positions) {
					returnString += "[ " + ExpressionTranslator.instance().translate(currentPosition) + ".getIntegerValue()]";
				}
				return returnString + ".assign(" + ExpressionTranslator.instance().translate(expression) + ");";
				
			case String:
				for (ASTExpression currentPosition : positions) {
					returnString += "[ " + ExpressionTranslator.instance().translate(currentPosition) + ".getIntegerValue()]";
				}
				return returnString + " = " + ExpressionTranslator.instance().translate(expression) + ";";
			}
			break;
		}
		throw new RuntimeException("Unknown type " + type);
	}

	public static enum Nature {
		Array,
		Variable
	}
}