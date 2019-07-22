package canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.dk.exception.InvalidInputException;
import com.dk.shape.Canvas;
import com.dk.shape.Line;

public class LineTest {
	@Test
	public void testDraw() throws InvalidInputException {
		Canvas canvas = new Canvas();
		canvas.draw(6, 4);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' }, { '|', 'x', 0, 0, 0, '|' },
				{ '|', 'x', 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertTrue(canvas.shape != null);
		assertTrue(canvas.getHeight() == 4);
		assertTrue(canvas.getWidth() == 6);

		System.out.println(canvas.shape);

		Line line = new Line();
		line.shape = canvas.shape;

		line.draw(1, 2, 1, 3);

		assertEquals(Arrays.deepToString(line.shape), Arrays.deepToString(expected));
	}
}
