package immutablelist;

import java.util.NoSuchElementException;

public class Nil<T> implements ImmutableList<T> {

	@Override
	public T get(int index) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public ImmutableList<T> add(int index, T element) {
		if (index == 0)
			return prepend(element);
		else
			throw new IndexOutOfBoundsException();
	}

	@Override
	public <U> ImmutableList<U> map(Function<? super T, ? extends U> fn) {
		return new Nil<U>();
	}

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

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return getClass() == obj.getClass();
	}
}
