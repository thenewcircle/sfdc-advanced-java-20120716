package immutablelist;

public class ToStringFunction implements Function<Object, String> {

	@Override
	public String apply(Object input) {
		return input.toString();
	}

}
