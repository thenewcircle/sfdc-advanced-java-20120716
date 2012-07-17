package immutablelist.test;

import static org.junit.Assert.assertEquals;
import immutablelist.ImmutableList;
import immutablelist.Nil;

import org.junit.Test;

public class ImmutableListTest {

	private static final ImmutableList<Character>
		empty = new Nil<Character>(),
		c = empty.prepend('c'),
		b = c.prepend('b'),
		a = b.prepend('a');

	@Test
	public void getMustWork() {
		assertEquals('b', (char) a.get(1));
	}

}
