package com.dk.shape;

import com.dk.exception.InvalidInputException;
import com.dk.utils.Validator;

public class Line extends Shape {

	public void draw(int x1, int y1, int x2, int y2) throws InvalidInputException {

		Validator.validateLine(x1, y1, x2, y2);		
		drawLine(x1, y1, x2, y2, 'x');
		
		StringBuilder results = new StringBuilder();

		for (int i = 0; i < shape.length; ++i) {
			for (int j = 0; j < shape[i].length; j++) {
				results.append((shape[i][j]) == 0 ? " " : shape[i][j]);
			}
			results.append("\n");
		}

		System.out.print(results);

	}

	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();

		canvas.draw(20, 20);
		Line line = new Line();

		line.shape = canvas.shape;
		line.draw(5, 2, 15, 2);

	}
}
