import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

public class MoveForwardBehavior implements Behavior {
	
	private boolean suppressed = false;
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Moving", 0, 0);
		pilot.forward();
	    while( !suppressed )
	        Thread.yield();
		pilot.stop();
		LCD.clear();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}