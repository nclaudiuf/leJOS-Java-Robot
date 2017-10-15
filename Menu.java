import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Menu {
	
	private boolean displayRun = true;
	private boolean angleRun = true;
	private boolean sideRun = true;
	private boolean distanceRun = true;
	private boolean repeatRun = true;
	private int valuesRepeat = 1;
	private int side = 0;
	private int arrowlocation = 1;
	private int angleValue = 0;	
	private int distanceValue = 0;
	
	public int getArrowlocation()
	{
		return arrowlocation;
	}
	
	public int getValuesRepeat()
	{
		return valuesRepeat;
	}
	
	public int getSide()
	{
		return side;
	}
	
	public int getAngleValue()
	{
		return angleValue;
	}
	
	public int getDistanceValue()
	{
		return distanceValue;
	}
	
	public void resetValues()
	{
		angleValue = 0;
		distanceValue = 0;
	}
	
	public void displayRun() throws InterruptedException
	{
		while (displayRun) 
		{
			LCD.clearDisplay();
			LCD.drawString("Pick an option", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("Angle", 1, 2);
			LCD.drawString("Distance", 1, 3);

			// Draw the arrow
			if (arrowlocation == 1) 
				LCD.drawString(">", 0, 2);
			
			if (arrowlocation == 2) 
				LCD.drawString(">", 0, 3);
			

			// Check for button press and repeat
			if (Button.LEFT.isDown()) 
				arrowlocation = 1;
			
			if (Button.RIGHT.isDown()) 
				arrowlocation = 2;
			
			if (Button.ENTER.isDown())
				displayRun = false;
			
			Thread.sleep(150);
		}
		
		displayRun = true;
		Thread.sleep(250);
	}
	
	public void angleRun() throws InterruptedException
	{
		while (angleRun) 
		{
			LCD.clearDisplay();
			LCD.drawString("Angle value", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("" + angleValue, 1, 2);

			// Check for button press and repeat
			if (Button.LEFT.isDown()) 
				angleValue = angleValue - 5;
			
			if (Button.RIGHT.isDown()) 
				angleValue = angleValue + 5;
			
			if (Button.ENTER.isDown()) 
				angleRun = false;
			
			Thread.sleep(150);
		}
		
		angleRun = true;
		Thread.sleep(200);
	}
	
	public void sideRun() throws InterruptedException
	{
		// Side choosing menu (left/right)
		while (sideRun)
		{
			LCD.clearDisplay();
			LCD.drawString("Choose side", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("Left", 1, 2);
			LCD.drawString("Right", 1, 3);

			// Draw the arrow
			if (arrowlocation == 1) 
			{
				LCD.drawString(">", 0, 2);
				side = 1;
			}
			 
			if (arrowlocation == 2) 
			{
				LCD.drawString(">", 0, 3);
				side = 2;
			}
			
			// Check for button press and repeat
			if (Button.LEFT.isDown()) {
				arrowlocation = 1;
			}
			if (Button.RIGHT.isDown()) {
				arrowlocation = 2;
			}
			if (Button.ENTER.isDown()) 
				sideRun = false;
			
			Thread.sleep(150);
		}						
		sideRun = true;				
		Thread.sleep(200);
		
		distanceValue = 0;
	}
	
	public void distanceRun() throws InterruptedException
	{
		while (distanceRun) 
		{
			LCD.clearDisplay();
			LCD.drawString("Distance", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("" + distanceValue, 1, 2);

			// Check for button press and repeat
			if (Button.LEFT.isDown()) 
				distanceValue = distanceValue - 1;
		
			if (Button.RIGHT.isDown()) 
				distanceValue = distanceValue + 5;
			
			if (Button.ENTER.isDown()) 
				distanceRun = false;
			
			Thread.sleep(150);
		}
			distanceRun = true;									
			Thread.sleep(200);	
			
			angleValue = 0;	
	}

	public void repeatRun() throws InterruptedException
	{
		valuesRepeat = 1;
		while (repeatRun) 
		{
			LCD.clearDisplay();
			LCD.drawString("Enter more?", 1, 0);
			LCD.drawString("--------------", 1, 1);
			LCD.drawString("Yes", 1, 2);
			LCD.drawString("No", 1, 3);

			// Draw the arrow
			if (valuesRepeat == 1)
				LCD.drawString(">", 0, 2);
			 
			if (valuesRepeat == 2) 
				LCD.drawString(">", 0, 3);
			

			// Check for button press and repeat
			if (Button.LEFT.isDown()) 
				valuesRepeat = 1;
			
			if (Button.RIGHT.isDown()) 
				valuesRepeat = 2;
			
			if (Button.ENTER.isDown()) {
				repeatRun = false;
			}	
			Thread.sleep(150);
		}		
		repeatRun = true;									
		Thread.sleep(250);
	}
}
