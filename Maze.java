import lejos.nxt.*;

public class Maze {

	public static void main(String[] args) throws InterruptedException {
		boolean angleRun = true;				//Running the angle input value menu
		boolean distanceRun = true;				//Running the distance input value menu
		boolean repeatRun = true;				//Running the repeat menu
		boolean displayRun = true;				//Running the display menu 
		boolean enteringValues = true;			//Running the entire enter value module
		int arrowlocation = 1;					//The arrow pointer and menu selector
		int distanceValue = 0;					//container for distance. 	(Store these in arrays)
		int angleValue = 0;						//container for angle.		(Store these in arrays)
		
		while (enteringValues == true)
		{
			Thread.sleep(250);				
		while (displayRun == true) {
			LCD.clearDisplay();
			LCD.drawString("Pick an option", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("Angle", 1, 2);
			LCD.drawString("Distance", 1, 3);

			// Draw the arrow
			if (arrowlocation == 1) {
				LCD.drawString(">", 0, 2);
			} 	
			if (arrowlocation == 2) {
				LCD.drawString(">", 0, 3);
			}

			// Check for button press and repeat
			if (Button.LEFT.isDown()) {
				arrowlocation = 1;
			}
			if (Button.RIGHT.isDown()) {
				arrowlocation = 2;
			}
			if (Button.ENTER.isDown()) {
				displayRun = false;
			}
			Thread.sleep(150);
			}
			displayRun = true;
			Thread.sleep(250);
			
			//Run the angle input menu
		if (arrowlocation == 1)
		{
		while (angleRun == true) {
			LCD.clearDisplay();
			LCD.drawString("Angle value", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("" + angleValue, 1, 2);

			// Check for button press and repeat
			if (Button.LEFT.isDown()) {
				angleValue = angleValue - 15;
			}
			if (Button.RIGHT.isDown()) {
				angleValue = angleValue + 15;
			}
			if (Button.ENTER.isDown()) {
				angleRun = false;
			}
			angleRun = true;
			Thread.sleep(200);
			}
		}
		
			//Else run the distance input menu
		else {
		while (distanceRun == true) {
			LCD.clearDisplay();
			LCD.drawString("Distance", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("" + distanceValue, 1, 2);

			// Check for button press and repeat
			if (Button.LEFT.isDown()) {
				distanceValue = distanceValue - 5;
			}
			if (Button.RIGHT.isDown()) {
				distanceValue = distanceValue + 5;
			}
			if (Button.ENTER.isDown()) {
				distanceRun = false;
			}
			distanceRun = true;
			Thread.sleep(200);
			}	
			}
		
		//Menu for entering more input
		Thread.sleep(200);
		int valuesRepeat = 1;
		while (repeatRun == true) {
			LCD.clearDisplay();
			LCD.drawString("Enter more?", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("Yes", 1, 2);
			LCD.drawString("No", 1, 3);

			// Draw the arrow
			if (valuesRepeat == 1) {
				LCD.drawString(">", 0, 2);
			} 
			if (valuesRepeat == 2) {
				LCD.drawString(">", 0, 3);
			}

			// Check for button press and repeat
			if (Button.LEFT.isDown()) {
				valuesRepeat = 1;
			}
			if (Button.RIGHT.isDown()) {
				valuesRepeat = 2;
			}
			if (Button.ENTER.isDown()) {
				repeatRun = false;
			Thread.sleep(150);
			}
			repeatRun = true;									
			if (valuesRepeat == 2)
			{
			enteringValues = false;
			}
			Thread.sleep(250);
												//At this point, store information in arrays
												//distanceValue and angleValue
		}
			LCD.clearDisplay();
			System.out.println("DONE.");		//At this point, run the program from the arrays...
			Thread.sleep(150);
			Button.waitForAnyPress();
		}
		}


	public static void distanceModule(int i){	//Add a distance module
		
	}

	public static void angleModule(int i) {		//Add an angle module
		
	}

}
