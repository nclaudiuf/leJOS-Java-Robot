import lejos.nxt.*;

public class Maze_try {

	public static void main(String[] args) throws InterruptedException {

		boolean enteringValues = true;
		boolean displayRun = true;
		boolean repeatRun = true;
		boolean angleRun = true;
		boolean distanceRun = true;
		int arrowLocation = 1;
		int angleValue = 0;
		int distanceValue = 0;
		int repeatValue = 0;

		while (enteringValues == true) {
			Thread.sleep(250);

			while (displayRun == true) {
				LCD.clearDisplay();
				LCD.drawString("Pick up an option", 1, 0);
				LCD.drawString("--------------", 1, 1);
				LCD.drawString("Angle", 1, 2);
				LCD.drawString("Distance", 1, 3);

				// Draw the arrow on the screen ;
				if (arrowLocation == 1) {
					LCD.drawString(">", 0, 2);
				}
				if (arrowLocation == 2) {
					LCD.drawString(">", 0, 3);
				}

				// Chek for the button press and repeat
				if (Button.LEFT.isDown()) {
					arrowLocation = 1;

				}
				if (Button.RIGHT.isDown()) {
					arrowLocation = 2;
				}

				// End the while loop if press Enter
				if (Button.ENTER.isDown()) {
					displayRun = false;
					Thread.sleep(250);
				}
				displayRun = true;
			}

			if (arrowLocation == 1) {
				while (angleRun == true) {
					LCD.clearDisplay();
					LCD.drawString("Angle value", 1, 0);
					LCD.drawString("-----------", 1, 1);
					LCD.drawString("" + angleValue, 1, 2);

					// Check for buttons and repeat
					if (Button.LEFT.isDown()) {
						angleValue += angleValue - 15;
					}
					if (Button.RIGHT.isDown()) {
						angleValue += angleValue + 15;

					}
					if (Button.ENTER.isDown()) {
						angleRun = false;
						Thread.sleep(250);
					}
					angleRun = true;
				}
			}

			// if arrowLocation = 2 , means the distance
			else {
				while (distanceRun == true) {
					LCD.clearDisplay();
					LCD.drawString("Distance value ", 1, 0);
					LCD.drawString("-------------", 1, 1);
					LCD.drawString("" + distanceValue, 1, 2);

					if (Button.LEFT.isDown()) {
						distanceValue += distanceValue - 1;

					}
					if (Button.RIGHT.isDown()) {
						distanceValue += distanceValue + 1;
					}
					if (Button.ENTER.isDown()) {
						distanceRun = false;
						Thread.sleep(250);
					}
					distanceRun = true;
				}
			}

			while (repeatRun = true) {
				LCD.clearDisplay();
				LCD.drawString("More values?", 1, 0);
				LCD.drawString("---------", 1, 1);
				LCD.drawString("Yes", 3, 2);
				LCD.drawString("No", 3, 3);

				// DRAW THE ARROW
				if (repeatValue == 1) {
					LCD.drawString(">", 0, 2);
				}
				if (repeatValue == 2) {
					LCD.drawString(">", 0, 3);
				}

				// Buttons and repeat
				if (Button.LEFT.isDown()) {
					repeatValue = 1;
				}
				if (Button.RIGHT.isDown()) {
					repeatValue = 2;
				}
				if (Button.ENTER.isDown()) {
					repeatRun = false;

					Thread.sleep(250);
				}
				repeatRun = true;
				if (repeatValue == 2) {
					enteringValues = false;
				}
				Thread.sleep(250);

				LCD.clearDisplay();
				LCD.drawString("Ready to go !", 1, 3);
				Thread.sleep(250);
				Button.waitForAnyPress();

			}
		}

	}
}
