package shapes;

import static junit.framework.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import shapes.Rectangle;
import shapes.Square;

public class ShapeTest {

	@Test
	public void settingSquareWidthShouldAlsoSetSquareHeight() {
		Square s = new Square(1);
		s.setWidth(2);
		assertEquals(2, s.getHeight());
	}

	@Test
	public void rectangleAreaMustBeWidthTimesHeight() {
		for (int i = 0; i < 100; i++) {
			Rectangle r = getArbitraryRectangle();
			assertEquals(r.getWidth() * r.getHeight(), r.getArea());
		}
	}

	@Test
	public void setHeightShouldNotAffectWidth() {
		for (int i = 0; i < 100; i++) {
			Rectangle r = getArbitraryRectangle();
			int width = r.getWidth();
			r.setHeight(5);
			assertEquals(width, r.getWidth());
		}
	}

	private static Rectangle getArbitraryRectangle() {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			return new Square(rand.nextInt(10));
		} else {
			return new Rectangle(rand.nextInt(10), rand.nextInt(10));
		}
	}

}
