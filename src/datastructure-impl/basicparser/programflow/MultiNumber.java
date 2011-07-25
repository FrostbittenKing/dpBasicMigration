package basicparser.programflow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.text.rtf.RTFEditorKit;

import basicparser.programflow.MultiNumber;

public class MultiNumber {
	private Integer ivalue;
	private Double dvalue;

	private boolean isDouble;

	public MultiNumber() {
	}

	public MultiNumber(int value) {
		this.ivalue = value;
		isDouble = false;
	}

	public MultiNumber(double value) {
		this.dvalue = value;
		isDouble = true;
	}

	public MultiNumber(boolean value) {
		if (value) {
			this.ivalue = 1;
		}
		else {
			this.ivalue = 0;
		}
		isDouble = false;
	}
	
	public MultiNumber(MultiNumber num){
		if (num.isDouble)
			this.dvalue = num.getDoubleValue();
		else
			this.ivalue = num.getIntegerValue();
	}

	public boolean IsDouble() {
		return isDouble;
	}
	
	

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public Integer getIntegerValue() {
		return ivalue;
	}

	public Double getDoubleValue() {
		return dvalue;
	}
	
	public void assign(MultiNumber a) {
		if (a.isDouble) {
			dvalue = a.dvalue;
		}
		else {
			ivalue = a.ivalue;
		}
	}

	public static MultiNumber add(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() + b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() + b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() + b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() + b.getDoubleValue());
			}
		}
	}

	public static MultiNumber sub(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() - b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() - b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() - b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() - b.getDoubleValue());
			}
		}
	}

	public static MultiNumber mul(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() * b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() * b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() * b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() * b.getDoubleValue());
			}
		}
	}

	public static MultiNumber div(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() / b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() / b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() / b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() / b.getDoubleValue());
			}
		}
	}
	
	public static MultiNumber sgn(MultiNumber a){
		if (a.isDouble){
			if (a.getDoubleValue() > 0)
				return new MultiNumber(1.00);
			else if (a.getDoubleValue() < 0)
				return new MultiNumber(-1.00);
			else
				return new MultiNumber(0.00);
		}
		else{
			if (a.getIntegerValue() > 0)
				return new MultiNumber(1);
			else if (a.getIntegerValue() < 0)
				return new MultiNumber(-1);
			else
				return new MultiNumber(0);
		}
	}

	public static MultiNumber exp(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(Math.pow(a.getIntegerValue(),b.getIntegerValue()));
			}
			else {
				return new MultiNumber(Math.pow(a.getIntegerValue(),b.getDoubleValue()));
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(Math.pow(a.getDoubleValue(),b.getIntegerValue()));
			}
			else {
				return new MultiNumber(Math.pow(a.getDoubleValue(),b.getDoubleValue()));
			}
		}
	}

	public static MultiNumber ge(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() >= b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() >= b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() >= b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() >= b.getDoubleValue());
			}
		}
	}

	public static MultiNumber gt(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() > b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() > b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() > b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() > b.getDoubleValue());
			}
		}
	}

	public static MultiNumber lt(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() < b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() < b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() < b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() < b.getDoubleValue());
			}
		}
	}

	public static MultiNumber le(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() <= b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue() <= b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() <= b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() <= b.getDoubleValue());
			}
		}
	}

	public static MultiNumber ne(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() != b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue().doubleValue() != b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() != b.getIntegerValue().doubleValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() != b.getDoubleValue());
			}
		}
	}

	public static MultiNumber and(MultiNumber a, MultiNumber b) throws Exception {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() & b.getIntegerValue());
			}
		}
		throw new Exception("Error, cannot do binary operations on double values");
	}

	public static MultiNumber or(MultiNumber a, MultiNumber b) throws Exception {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() | b.getIntegerValue());
			}
		}
		throw new Exception("Error, cannot do binary operations on double values");
	}

	public static MultiNumber compare(MultiNumber a, MultiNumber b) {
		if (!a.isDouble) {
			if (!b.isDouble) {
				return new MultiNumber(a.getIntegerValue() == b.getIntegerValue());
			}
			else {
				return new MultiNumber(a.getIntegerValue().doubleValue() == b.getDoubleValue());
			}
		}
		else {
			if (!b.isDouble) {
				return new MultiNumber(a.getDoubleValue() == b.getIntegerValue().doubleValue());
			}
			else {
				return new MultiNumber(a.getDoubleValue() == b.getDoubleValue());
			}
		}
	}

	public boolean isTrue() {
		return isDouble ? dvalue != 0 : ivalue != 0;
	}

	public static MultiNumber toggleSignum(MultiNumber a) {
		if (a.isDouble) {
			a.dvalue *= -1;
		}
		else {
			a.ivalue *= -1;
		}
		return a;
	}
	
	public static MultiNumber mathFunction(String functionName, MultiNumber ...multiNumbers) {
		Object returnVal = null;
		try {
			Class<?> mathClass = Class.forName("java.lang.Math");
			
			Object [] parameters = new Object[multiNumbers.length];
			
			Method [] mathMethods = mathClass.getDeclaredMethods();
			Method mathMethod = null;
			for(Method currentMethod : mathMethods) {
				if (currentMethod.getName().contentEquals(functionName)) {
					mathMethod = currentMethod;
					break;
				}
			}
			
			int posCount = 0;
			for (MultiNumber parameter : multiNumbers) {
				if (parameter.isDouble) {
					parameters[posCount] = parameter.getDoubleValue();
					//parameters[posCount] = Class.forName(parameterClasses[posCount].getCanonicalName()).cast(parameter.getDoubleValue());
				}
				else {
					parameters[posCount] = parameter.getIntegerValue();
			//		parameters[posCount] = Class.forName(className)
				}
				posCount++;
			}
			
			
			
			if (mathMethod != null) {
				returnVal = mathMethod.invoke(mathClass, (Object [])parameters);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (returnVal instanceof Double) {
			return new MultiNumber((Double) returnVal);
		}
		else {
			return new MultiNumber((Integer)returnVal);
		}
	}

	@Override
	public String toString() {
		if (isDouble){
			return dvalue.toString();
		}
		else {
			return ivalue.toString();
		}
	}
	
	
	

}