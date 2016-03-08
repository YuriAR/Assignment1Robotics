import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.*;

public class Assingment1 {

	public static void main(String[] args) {
		SoundSensor sound = new SoundSensor(SensorPort.S3,true);
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		
		while(sound.readValue()<40){
			LCD.drawString("Ready", 0, 0);
		}
		LCD.clear();
		LCD.drawString("Clap", 0, 0);
		LCD.clear();
/* 		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
		LightSensor light = new LightSensor(SensorPort.S2);
		while (true) {
			LCD.drawInt(sonic.getDistance(), 4, 0, 0);
			LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1); //400-430 (dark lab table) / 650-680 (white paper)
		} */
		
		//Behavior b1 = new ClapBehavior();
		Behavior b2 = new Turn90LightBehavior();
		Behavior b3 = new UltrasonicSensorBehavior();
		Behavior b4 = new BumperBehavior();
		Behavior b5 = new MoveForwardBehavior();
	    Behavior [] bArray = {b5,b2,b3,b4};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
}
