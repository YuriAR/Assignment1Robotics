import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

public class Turn90LightBehavior implements Behavior {
	
	private boolean suppressed = false;
	LightSensor light = new LightSensor(SensorPort.S2);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		if(light.getNormalizedLightValue() > 600){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Light", 0, 0);
		pilot.rotate(-80,false);
		LCD.clear();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
