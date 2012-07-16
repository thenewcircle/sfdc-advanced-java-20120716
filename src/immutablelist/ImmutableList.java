package immutablelist;

import java.util.ArrayList;
import java.util.List;

public class ImmutableList<T> {

	private final List<T> list = new ArrayList<T>();

	public ImmutableList() {}
	public ImmutableList<T> prepend(T element) { return null; }

	public T head() { return null; }
	public ImmutableList<T> tail() { return null; }
	public boolean isEmpty() { return false; }

}
