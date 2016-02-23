import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.Button;

public class Assingment1 {

	public static void main(String[] args) {
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		Behavior b1 = new ClapBehavior();
	    Behavior [] bArray = {b1};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
}
