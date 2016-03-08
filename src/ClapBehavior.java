import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

public class ClapBehavior implements Behavior{
	
	SoundSensor sound = new SoundSensor(SensorPort.S3,true);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		if(sound.readValue()>40){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Clap", 0, 0);
		LCD.clear();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
