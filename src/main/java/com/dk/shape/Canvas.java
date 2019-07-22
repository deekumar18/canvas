package com.dk.shape;

import com.dk.exception.InvalidInputException;
import com.dk.utils.Validator;

public class Canvas extends Shape {
	
	private int width;
	private int height;

	public void draw(int width, int height) throws InvalidInputException {
		
		this.width = width;
		
		if(width == 1){
			width = width+2;
		}
		this.height = height;
		
		Validator.validateCanvas(height, width);		

		shape = new char[height + 2][width];
		
		// upper line		
		drawLine(0, 0, width - 1, 0, '-');		
		// left line
		drawLine(0, 1, 0, height + 1, '|');		
		// right line
		drawLine(width - 1, 1, width - 1, height + 1, '|');
		// lower line
		drawLine(0, height + 1, width - 1, height + 1, '-');

		StringBuilder results = new StringBuilder();

		for (int i = 0; i < shape.length; ++i) {
			for (int j = 0; j < shape[i].length; j++) {
				results.append((shape[i][j]) == 0 ? " " : shape[i][j]);
			}
			results.append("\n");
		}
		System.out.print(results);
	}
	
	
	public int getWidth() {
		return width;
	}




	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();
		canvas.draw(20, 5);
	}

}
