package fruits;
import java.util.List;

public class Demo {

	public static interface Fruit {}
	public static class Orange implements Fruit {}

	// covariance
	public static <T> T get(List<? extends T> list) {
		return list.get(0);
	}

	// contravariance
	public static <T> void put(T element, List<? super T> list) {
		list.add(element);
	}

	// invariance
	public static <T> T getAndPut(T element, List<T> list) {
		T old = get(list);
		put(element, list);
		return old;
	}

	public static void test() {
		List<Orange> oranges = null;
		get(oranges);

		List<Fruit> fruits = null;
		put(new Orange(), fruits);
	}

}
