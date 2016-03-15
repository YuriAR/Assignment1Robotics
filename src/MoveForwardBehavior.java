import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */
 
//Behavior that handles the moving forward task
//This behavior moves the robot forward until it gets supressed (always wants control)

public class MoveForwardBehavior implements Behavior {
	
	private boolean suppressed = false;
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		boolean testClap = Assingment1.getClap();		//Test if the sound sensor detected a clap before (through a variable declared in main)
		if (testClap){
			return true;
		}
		else{
			return false;
		}
		
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