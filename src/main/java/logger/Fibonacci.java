package logger;

public class Fibonacci {

	public static int fib(int n) {
		switch (n) {
		case 0:
		case 1:
			return 1;
		default:
			return fib(n-1) + fib(n-2);
		}
	}

}
