import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class ClapBehavior implements Behavior{
	
	SoundSensor sound = new SoundSensor(SensorPort.S2,true);
	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		suppressed = false;
		if(sound.readValue()>40){
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		LCD.drawString("Clap", 0, 0);
		Motor.B.forward();
	    Motor.C.forward();
		while( !suppressed )
			Thread.yield();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
