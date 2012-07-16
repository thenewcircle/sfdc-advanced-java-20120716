package immutablelist;

import java.util.NoSuchElementException;

public class Nil<T> implements ImmutableList<T> {

	@Override
	public ImmutableList<T> prepend(T element) {
		return new Cons<T>(element, this);
	}

	@Override
	public T head() {
		throw new NoSuchElementException();
	}

	@Override
	public ImmutableList<T> tail() {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
