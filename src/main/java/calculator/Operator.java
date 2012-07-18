package calculator;

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
}
