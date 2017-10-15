import lejos.nxt.Button;
import lejos.nxt.LCD;

import java.util.ArrayList;

public class TheMaze {

	public static void main(String[] args) throws InterruptedException {

		boolean enteringValues = true;

		ArrayList<Movement> moves = new ArrayList<Movement>();

		Menu menu = new Menu();

		while (enteringValues) {
			menu.resetValues();

			Thread.sleep(250);

			menu.displayRun();

			if (menu.getArrowlocation() == 1) {
				menu.angleRun();
				menu.sideRun();
			} else
				menu.distanceRun();

			menu.repeatRun();

			if (menu.getValuesRepeat() == 2)
				enteringValues = false;

			moves.add(new Movement(menu.getAngleValue(), menu
					.getDistanceValue(), menu.getSide()));

		}
		LCD.clearDisplay();
		System.out.println("READY TO GO!");
		Thread.sleep(150);
		Button.waitForAnyPress();
		Thread.sleep(1000);

		TheRun run = new TheRun();

		for (int i = 0; i < moves.size(); i++) {
			if (moves.get(i).getAngle() == 0)
				run.Distance(moves.get(i).convertDistance());

			if (moves.get(i).getDistance() == 0)
				run.Turn(moves.get(i).getSide(), moves.get(i).convertAngle());
		}

	}
}
