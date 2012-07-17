package immutablelist;

public class Cons<T> implements ImmutableList<T> {

	private final T head;
	private final ImmutableList<T> tail;

	public Cons(T head, ImmutableList<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public T get(int index) {
		return (index == 0)
			? head
			: tail.get(index - 1);
	}

	@Override
	public ImmutableList<T> add(int index, T element) {
		if (index == 0)
			return prepend(element);
		else
			return tail.add(index - 1, element).prepend(head);
	}

	@Override
	public <U> ImmutableList<U> map(Function<T, U> fn) {
		return tail.map(fn).prepend(fn.apply(head));
	}

	@Override
	public ImmutableList<T> prepend(T element) {
		return new Cons<T>(element, this);
	}

	@Override
	public T head() {
		return head;
	}

	@Override
	public ImmutableList<T> tail() {
		return tail;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cons<?> other = (Cons<?>) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		return true;
	}

}
