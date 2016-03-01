import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

public class UltrasonicSensorBehavior implements Behavior {
	
	private boolean suppressed = false;
	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
	LightSensor light = new LightSensor(SensorPort.S3);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
	
	@Override
	public boolean takeControl() {
		//Only takes control if its driving on a dark floor, that means, after the light behavior? maybe
		if(sonic.getDistance() < 26 && light.getNormalizedLightValue() < 430){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Sonar", 0, 0);
		pilot.rotate(-180,false);
		pilot.travel(20,false);
		pilot.rotate(90,false);
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
