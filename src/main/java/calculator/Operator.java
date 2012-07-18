package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
	ADD {
		public int apply(int lhs, int rhs) {
			return lhs + rhs;
		}

		public String toString() {
			return "+";
		}
	},
	SUBTRACT {
		public int apply(int lhs, int rhs) {
			return lhs - rhs;
		}

		public String toString() {
			return "-";
		}
	},
	MULTIPLY {
		public int apply(int lhs, int rhs) {
			return lhs * rhs;
		}

		public String toString() {
			return "*";
		}
	},
	DIVIDE {
		public int apply(int lhs, int rhs) {
			return lhs / rhs;
		}

		public String toString() {
			return "/";
		}
	};

	public abstract int apply(int lhs, int rhs);

	private static final Map<String, Operator> SYMBOLS = new HashMap<String, Operator>();
	static {
		SYMBOLS.put("+", ADD);
		SYMBOLS.put("-", SUBTRACT);
		SYMBOLS.put("*", MULTIPLY);
		SYMBOLS.put("/", DIVIDE);
	}

	public static Operator parse(String token) {
		return SYMBOLS.get(token);
	}
}
