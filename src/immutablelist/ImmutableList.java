package immutablelist;

public interface ImmutableList<T> {

	T get(int index);
	ImmutableList<T> add(int index, T element);

	<U> ImmutableList<U> map(Function<? super T, ? extends U> fn);

	ImmutableList<T> prepend(T element);
	T head();
	ImmutableList<T> tail();
	boolean isEmpty();

}
