import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.TouchSensor;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */
 
//Behavior that handles the touch sensor
//This behavior makes the robot stop if the bumper is activated
 
public class BumperBehavior implements Behavior {
	
	private boolean suppressed = false;
	TouchSensor touch = new TouchSensor(SensorPort.S4);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		if(touch.isPressed()){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Stop", 0, 0);
		pilot.stop();
	    while( !suppressed )
	        Thread.yield();
		LCD.clear();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}