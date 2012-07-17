package logger;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {

		final BlockingQueue<Integer> work = new LinkedBlockingQueue<Integer>(1000);

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					while (true) {
						try {
							work.put(new Random().nextInt(30));
						} catch (InterruptedException e) {}
					}
				}
			};
			t.start();
		}

		Thread t = new Thread() {
			public void run() {
				while (true) {
					try {
						System.out.println(Fibonacci.fib(work.take()));
					} catch (InterruptedException e) {}
				}
			}
		};
		t.start();
	}

}
