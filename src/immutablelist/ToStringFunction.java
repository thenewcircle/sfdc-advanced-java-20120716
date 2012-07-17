package immutablelist;

public class ToStringFunction<T> implements Function<T, String> {

	@Override
	public String apply(T input) {
		return input.toString();
	}

}
