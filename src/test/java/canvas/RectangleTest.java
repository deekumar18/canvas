package canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.dk.exception.InvalidInputException;
import com.dk.shape.Canvas;
import com.dk.shape.Rectangle;

public class RectangleTest {

	@Test
	public void testDraw() throws InvalidInputException {
		Canvas canvas = new Canvas();
		canvas.draw(6, 5);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertTrue(canvas.shape != null);
		assertTrue(canvas.getHeight() == 5);
		assertTrue(canvas.getWidth() == 6);

		System.out.println(canvas.shape);

		Rectangle rect = new Rectangle();

		rect.shape = canvas.shape;

		rect.draw(1, 1, 4, 4);

		assertEquals(Arrays.deepToString(rect.shape), Arrays.deepToString(expected));
	}
}
