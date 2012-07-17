package logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		final Queue<Integer> work = new LinkedList<Integer>();
		final Object monitor = new Object();

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}
						synchronized (monitor) {
							work.add(new Random().nextInt(30));
							monitor.notify();
						}
					}
				}
			};
			t.start();
		}

		Thread t = new Thread() {
			public void run() {
				while (true) {
					synchronized (monitor) {
						try {
							monitor.wait();
						} catch (InterruptedException e) {}
						System.out.println(Fibonacci.fib(work.remove()));
					}
				}
			}
		};
		t.start();
	}

}
