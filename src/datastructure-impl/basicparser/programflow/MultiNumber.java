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

}