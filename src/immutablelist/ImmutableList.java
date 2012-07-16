package immutablelist;

import java.util.ArrayList;
import java.util.List;

public class ImmutableList<T> {

	private final List<T> list;

	public ImmutableList() {
		this.list = new ArrayList<T>();
	}

	private ImmutableList(List<T> list) {
		this.list = list;
	}

	public ImmutableList<T> prepend(T element) {
		List<T> copy = new ArrayList<T>();
		copy.add(element);
		copy.addAll(list);
		return new ImmutableList<T>(copy);
	}

	public T head() { return list.get(0); }

	public ImmutableList<T> tail() {
		List<T> copy = new ArrayList<T>(list);
		copy.remove(0);
		return new ImmutableList<T>(copy);
	}

	public boolean isEmpty() { return list.isEmpty(); }

}
