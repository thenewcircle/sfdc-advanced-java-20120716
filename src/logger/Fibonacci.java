package logger;

import java.util.Random;

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

	public static int randomFib() {
		return fib(new Random().nextInt(50));
	}
}
