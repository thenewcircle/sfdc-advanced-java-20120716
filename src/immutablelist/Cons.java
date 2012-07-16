package immutablelist;

public class Cons<T> implements ImmutableList<T> {

	private final T head;
	private final ImmutableList<T> tail;

	public Cons(T head, ImmutableList<T> tail) {
		this.head = head;
		this.tail = tail;
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

}
