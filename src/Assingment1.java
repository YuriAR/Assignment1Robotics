import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Assingment1 {

	public static void main(String[] args) {
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		
/* 		LightSensor light = new LightSensor(SensorPort.S3);
		while (true) {
			LCD.drawInt(light.getLightValue(), 4, 0, 0);
			LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1); //400-430 (dark lab table) / 650-680 (white paper)
			LCD.drawInt(SensorPort.S3.readRawValue(), 4, 0, 2);
			LCD.drawInt(SensorPort.S3.readValue(), 4, 0, 3);
		} */
		
		Behavior b1 = new ClapBehavior();
		Behavior b2 = new Turn90LightBehavior();
	    Behavior [] bArray = {b1,b2};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
}
