package immutablelist.test;

import static org.junit.Assert.assertEquals;
import immutablelist.Function;
import immutablelist.ImmutableList;
import immutablelist.Nil;
import immutablelist.ToStringFunction;

import org.junit.Test;

public class ImmutableListTest {

	private static final Function<Character, Character> TO_UPPERCASE_FN =
			new Function<Character, Character>() {

				@Override
				public Character apply(Character input) {
					return Character.toUpperCase(input);
				}
		
			};

	private static final ImmutableList<Character>
		empty = new Nil<Character>(),
		abc = empty.prepend('c').prepend('b').prepend('a');

	@Test
	public void getMustWork() {
		assertEquals('b', (char) abc.get(1));
	}

	@Test
	public void mapToUpperCaseMustWork() {
		ImmutableList<Character> expected = empty.prepend('C').prepend('B').prepend('A');
		assertEquals(expected, abc.map(TO_UPPERCASE_FN));
	}

	@Test
	public void mapToStringsMustWork() {
		ImmutableList<String> expected = new Nil<String>().prepend("c").prepend("b").prepend("a");
		assertEquals(expected, abc.map(new ToStringFunction()));
	}
	
}
