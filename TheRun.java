import lejos.nxt.MotorPort;

public class TheRun {	
	
	public void Distance(int distance) throws InterruptedException
	{
		int speed = 60;
		while(MotorPort.A.getTachoCount() < distance && MotorPort.B.getTachoCount() < distance)
		{
			while(speed < 99)
			{
				MotorPort.A.controlMotor(speed, 1);
				MotorPort.B.controlMotor(speed, 1);
				
				speed += 1;
				Thread.sleep(15);
			}
			
			MotorPort.A.controlMotor(99, 1);
			MotorPort.B.controlMotor(100, 1);
			// Move
		}
		
		MotorPort.A.controlMotor(100, 3);
		MotorPort.B.controlMotor(100, 3);
		
		// Reset
		MotorPort.A.resetTachoCount();
		MotorPort.B.resetTachoCount();
		
		Thread.sleep(300);
	}
	
	public void Turn(int side, int angle) throws InterruptedException
	{
		if(side == 1) // left
		{
			while(MotorPort.A.getTachoCount() < angle)
			{
				MotorPort.A.controlMotor(70, 1); // Run A
				MotorPort.B.controlMotor(100, 3); // Stop B
			}
			// Reset
			MotorPort.A.resetTachoCount();
		}
		
		else if(side == 2) // right
		{
			while(MotorPort.B.getTachoCount() < angle)
			{
				MotorPort.A.controlMotor(100, 3); // Stop A
				MotorPort.B.controlMotor(70, 1); // Run B
			}
			// Reset
			MotorPort.B.resetTachoCount();
		}
		
		// Reset both for later use
			MotorPort.A.resetTachoCount();
			MotorPort.B.resetTachoCount();
			
			Thread.sleep(250);
	}

}
