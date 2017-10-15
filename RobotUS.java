import lejos.nxt.Button;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RobotUS {
	public static void main(String[] args) {
		int TachoA = 70;
		int TachoB = 70;
		int back = 70;
		boolean run = true;
		int turn = 40;

		// creat and object
		UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S1);
		
		// check for button
		System.out.println("Press any button");
		Button.waitForAnyPress();


		// start running
		while (run) {
			MotorPort.A.controlMotor(70, 1);
			MotorPort.B.controlMotor(70, 1);

			while (ultra.getDistance() > 70) {

				MotorPort.A.controlMotor(turn, 4);
				turn += 1;
				turn = 65;

				MotorPort.A.resetTachoCount();
				MotorPort.A.controlMotor(70, 1);

			}

			while (ultra.getDistance() < 70) {

				MotorPort.B.controlMotor(turn, 4);
				turn += 1;
				turn = 65;
				MotorPort.B.resetTachoCount();
				MotorPort.B.controlMotor(70, 1);

			}

			while (ultra.getDistance() < 50 && ultra.getDistance() > 30) {
				while (ultra.getDistance() < 31 && TachoA < 720 && TachoB < 720) {

					// back
					for (int i = 90; back < i; back++) {
						MotorPort.A.controlMotor(back, 2);

						MotorPort.B.controlMotor(back, 2);

					}
				}
				// float and turn left
				MotorPort.B.controlMotor(0, 4);

				MotorPort.A.controlMotor(100, 1);
				MotorPort.A.resetTachoCount();
				MotorPort.B.resetTachoCount();
				TachoA = MotorPort.A.getTachoCount();
				TachoB = MotorPort.B.getTachoCount();
			}
			MotorPort.A.controlMotor(70, 1);
			MotorPort.B.controlMotor(70, 1);
		}
	}
}
