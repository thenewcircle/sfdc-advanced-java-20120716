package calculator;

import java.util.Stack;

public class Calculator {

	public static boolean parseNumber(String token, Stack<Expression> stack) {
		try {
			stack.push(new NumberExpression(Integer.parseInt(token)));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean parseOperator(String token, Stack<Expression> stack) {
		Operator op = Operator.parse(token);
		if (op == null) {
			return false;
		}

		Expression rhs = stack.pop(), lhs = stack.pop();
		stack.push(new OperationExpression(op, lhs, rhs));
		return true;
	}

	public static Expression parse(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
		for (String token : expression.split(" ")) {
			if (!parseNumber(token, stack) && !(parseOperator(token, stack)))
				throw new IllegalArgumentException("invalid expression");
		}
		return stack.pop();
	}

}
