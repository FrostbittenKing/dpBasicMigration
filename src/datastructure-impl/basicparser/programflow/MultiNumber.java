package basicparser.programflow;

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

	public boolean IsDouble() {
		return isDouble;
	}

	public Integer getIntegerValue() {
		return ivalue;
	}

	public Double getDoubleValue() {
		return dvalue;
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

}