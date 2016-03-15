import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */
 
//Behavior that handles the light sensor
//This behavior rotates the robot 90 degrees and ends

public class Turn90LightBehavior implements Behavior {
	
	private boolean suppressed = false;
	LightSensor light = new LightSensor(SensorPort.S2);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		boolean testClap = Assingment1.getClap();			//Test if the sound sensor detected a clap before (through a variable declared in main) 
		if (testClap){
			if(light.getNormalizedLightValue() > 600){		//A value greater than 600 is a light surface - value obtained by testing
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Light", 0, 0);
		pilot.rotate(-80,false);						 // 90 degrees - corrected error by testing
		LCD.clear();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
