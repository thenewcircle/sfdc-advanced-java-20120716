package calculator;

public final class OperationExpression implements Expression {

	private final Operator op;
	private final Expression lhs, rhs;

	public OperationExpression(Operator op, Expression lhs, Expression rhs) {
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Operator getOp() {
		return op;
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	@Override
	public String toString() {
		return "(" + lhs + op + rhs + ")";
	}

	@Override
	public int value() {
		return op.apply(lhs.value(), rhs.value());
	}

}
