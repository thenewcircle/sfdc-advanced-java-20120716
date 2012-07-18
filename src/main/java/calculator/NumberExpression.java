package calculator;

public final class NumberExpression implements Expression {

	private static final long serialVersionUID = 1L;
	private final int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberExpression other = (NumberExpression) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int value() {
		return number;
	}

}
