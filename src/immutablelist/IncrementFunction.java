package immutablelist;

public class IncrementFunction implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer input) {
		return input + 1;
	}

}
