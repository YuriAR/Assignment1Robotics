import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */

//Behavior that handles the Sonic sensor
//This behavior rotates the robot 180 degrees, moves forward 20 units, turns 90 degrees and ends

public class UltrasonicSensorBehavior implements Behavior {
	
	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	@Override
	public boolean takeControl() {
		boolean testClap = Assingment1.getClap(); //Test if the sound sensor detected a clap before (through a variable declared in main) 
		if (testClap){							  
			if(sonic.getDistance() < 26){		  //If yes, checks if the sonic sensor is reading a distance less than 26 cm to take control
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
		LCD.drawString("Sonar", 0, 0);			
		pilot.rotate(-150,false);				// 180 degrees - value with reduced error obtained by testing
		pilot.travel(20,false);
		pilot.rotate(80,false);					// 90 degrees - value with reduced error obtained by testing
		LCD.clear();
	}

	@Override
	public void suppress() {	
		pilot.stop();
	}

}
