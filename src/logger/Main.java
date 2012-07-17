package logger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		final Queue<Integer> work = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}
						work.add(new Random().nextInt(50));
					}
				}
			};
			t.start();
		}

		// TODO: implement a worker thread that computes fib(n) for each element in the work queue
	}

}
