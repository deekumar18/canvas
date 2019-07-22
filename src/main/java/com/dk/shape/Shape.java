package com.dk.shape;

import java.util.Arrays;


public abstract class Shape {

	public char[][] shape;

	public void drawLine(int x1, int y1, int x2, int y2, char drawChar) {
		if (x1 == x2) {
			// vertical line
			for (int i = y1; i <= y2; i++) {
				shape[i][x1] = drawChar;
			}
		} else if (y1 == y2) {
			// horizontal line
			Arrays.fill(shape[y1], x1, x2 + 1, drawChar);
		}
	}

}
