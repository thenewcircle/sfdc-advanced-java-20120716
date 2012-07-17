package logger;

import immutablelist.ImmutableList;
import immutablelist.Nil;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

	public static void main(String[] args) {

		final AtomicReference<ImmutableList<Integer>> work =
				new AtomicReference<ImmutableList<Integer>>(new Nil<Integer>());

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}

						ImmutableList<Integer> prev = null, next = null;
						do {
							prev = work.get();
							next = prev.prepend(new Random().nextInt(30));
						} while (!work.compareAndSet(prev, next));
					}
				}
			};
			t.start();
		}

		Thread t = new Thread() {
			public void run() {
				while (true) {
					ImmutableList<Integer> prev = null;
					do {
						prev = work.get();
					} while (prev.isEmpty() || !work.compareAndSet(prev, prev.tail()));
					System.out.println(Fibonacci.fib(prev.head()));
				}
			}
		};
		t.start();
	}

}
