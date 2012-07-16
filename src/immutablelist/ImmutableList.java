package immutablelist;


public interface ImmutableList<T> {

	ImmutableList<T> prepend(T element);
	T head();
	ImmutableList<T> tail();
	boolean isEmpty();

}
