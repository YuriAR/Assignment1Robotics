import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

public class Turn90LightBehavior implements Behavior {
	
	private boolean suppressed = false;
	LightSensor light = new LightSensor(SensorPort.S3);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
	
	@Override
	public boolean takeControl() {
		if(light.getNormalizedLightValue() > 650){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Light", 0, 0);
		pilot.rotate(-90,false);
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
