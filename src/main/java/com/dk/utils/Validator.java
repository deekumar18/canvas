package com.dk.utils;

import com.dk.exception.InvalidInputException;

public class Validator {

	public static void validateCanvas(int height, int width) throws InvalidInputException {
		if (height == 0 || width == 0) {
			throw new InvalidInputException("Supplied parameter should be greater then zero");
		}

		else if (width > 100) {
			throw new InvalidInputException("Supplied parameter should be less then 100");
		}

		else if (height > 100) {
			throw new InvalidInputException("Supplied parameter should be less then 100");
		}
	}

	public static void validateLine(int x1, int y1, int x2, int y2) throws InvalidInputException {
		if (x1 == 0 || x2 == 0 || y1 == 0 || y2 == 0) {
			throw new InvalidInputException("Supplied parameter should be greater then zero");
		}
		if(!(x1 == x2 || y1 == y2)){
			throw new InvalidInputException("Current implementation can draw only stright line");
		}
	}

	public static void validateRectangle(int x1, int y1, int x2, int y2) throws InvalidInputException {
		if (x1 == 0 || x2 == 0 || y1 == 0 || y2 == 0) {
			throw new InvalidInputException("Supplied parameter should be greater then zero");
		}
	}

	public static void validateInput(String[] input, int height, int width) throws InvalidInputException {
		for (int i = 1; i < input.length; i++) {
			if (!input[i].matches("[0-9]+")) {
				throw new InvalidInputException("Supplied parameter should be +ve Number only");
			}
		}

		if (Integer.parseInt(input[2]) > height || Integer.parseInt(input[4]) > height
				|| Integer.parseInt(input[1]) > width || Integer.parseInt(input[3]) > width) {
			throw new InvalidInputException("Supplied parameter out of canvas boundries");
		}

	}
}
