import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

public class Turn90LightBehavior implements Behavior {
	
	private boolean suppressed = false;
	LightSensor light = new LightSensor(SensorPort.S3);
	
	@Override
	public boolean takeControl() {
		
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		Motor.B.stop();
	    Motor.C.stop();
	    //rotate 90?
	    Motor.B.rotate(-180, true);
	    Motor.C.rotate(-360, true);
	    while( !suppressed )
	        Thread.yield();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
