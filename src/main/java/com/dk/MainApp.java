package com.dk;

import java.util.Scanner;

import com.dk.exception.InvalidInputException;
import com.dk.shape.Canvas;
import com.dk.shape.Line;
import com.dk.shape.Rectangle;
import com.dk.utils.AppConstant;
import com.dk.utils.Validator;

public class MainApp {
	public static void main(String[] args) {

		instructions();

		Canvas canvas = new Canvas();
		try (Scanner scanner = new Scanner(System.in)) {

			while (true) {
				System.out.print("Enter command: ");
				String tempStr = scanner.nextLine();
				String[] input;

				try {

					input = tempStr.split(" ");

					switch (input[0]) {

					case AppConstant.CANVAS:
						if (input.length > 3 || input.length <= 2) {
							throw new InvalidInputException(
									"Supplied parameter is wrong for canvas, Example - > C 20 20");
						}

						canvas.draw(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
						break;

					case AppConstant.LINE:					
						
						if (input.length > 5 || input.length <= 4) {
							throw new InvalidInputException(
									"Supplied parameter is wrong for Line, Example -> L 5 2 5 15");
						}
						if (canvas.shape == null) {
							throw new InvalidInputException("Draw Canvas First");
						}
						
						Validator.validateInput(input, canvas.getHeight(), canvas.getWidth());
						
						Line line = new Line();
						line.shape = canvas.shape;
						
						line.draw(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]),
								Integer.parseInt(input[4]));

						break;

					case AppConstant.RECTANGLE:
						
						if (input.length > 5 || input.length <= 4) {
							throw new InvalidInputException(
									"Supplied parameter is wrong for Rectengle, Example -> R 5 2 15 8 ");
						}
						if (canvas.shape == null) {
							throw new InvalidInputException("Draw Canvas First");
						}
						Validator.validateInput(input, canvas.getHeight(), canvas.getWidth());
						Rectangle rectangle = new Rectangle();
						rectangle.shape = canvas.shape;

						rectangle.draw(Integer.parseInt(input[1]), Integer.parseInt(input[2]),
								Integer.parseInt(input[3]), Integer.parseInt(input[4]));
						break;

					case AppConstant.QUIT:
						System.out.println("Application closed");
						System.exit(0);

					default:
						System.out.println("Invalid Input");
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void instructions() {
		String instructions = "BELOW ARE THE COMMAND:\n" + "1. Create a new canvas, Example -> C w h \n"
				+ "2. Draw on the canvas using text based commands \n" + "         Example (LINE DRAW)L x1 y1 x2 y2\n"
				+ "         or (RECTENGLE DRAW)R x1 y1 x2 y2 \n" + "3. Quit (press Q/q)\n\n\n";
		System.out.println(instructions);
	}

}
