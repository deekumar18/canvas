package canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.dk.exception.InvalidInputException;
import com.dk.shape.Canvas;

public class CanvasTest {

	@Test
	public void testDraw() throws InvalidInputException {
		Canvas canvas = new Canvas();
		canvas.draw(2, 2);
		char[][] expected = { { '-', '-' }, { '|', '|' }, { '|', '|' }, { '-', '-' } };
		assertTrue(canvas.shape != null);
		assertTrue(canvas.getHeight() == 2);
		assertTrue(canvas.getWidth() == 2);

		System.out.println(canvas.shape);

		assertEquals(Arrays.deepToString(canvas.shape), Arrays.deepToString(expected));

	}
}
