import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */
 
//Behavior that handles the sound sensor
//This behavior prints Claps on the screen and changes a control variable to allow other behaviors to execute

public class ClapBehavior implements Behavior{
	
	SoundSensor sound = new SoundSensor(SensorPort.S3,true);
	DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		boolean testClap = Assingment1.getClap();		//Test if the sound sensor detected a clap before (through a variable declared in main)
		if (!testClap){									//The clap behavior will only want to take control if it never did before (only once)
			if(sound.readValue()>40){					//A value greater than 40 is a clap sound - value obtained by testing
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
	public void action(){
		suppressed = false;
		LCD.drawString("Clap", 0, 0);				//Prints Clap and waits for 1 second
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			LCD.drawString("Exception", 0, 0);
		}
		LCD.clear();
		Assingment1.setClap();			//Notify the program that the clap already happened, allowing other behaviors to take control if they wish
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
