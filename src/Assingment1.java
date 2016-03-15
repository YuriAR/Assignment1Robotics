import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.*;

/* 

Assingment 1 - Mobile Robotics

Pedro Foltran - D14128455
Yuri Anfrisio Reis - D15124347

 */


public class Assingment1 {
	
	private static boolean  clapped = false;				//Variable that makes sure the clapping is always the first behavior to execute
															//It's used inside most of the behaviors, in the takeControl() method
	public static void main(String[] args) {
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		
		Behavior b1 = new ClapBehavior();
		Behavior b2 = new Turn90LightBehavior();
		Behavior b3 = new UltrasonicSensorBehavior();
		Behavior b4 = new BumperBehavior();
		Behavior b5 = new MoveForwardBehavior();
	    Behavior [] bArray = {b1,b5,b2,b3,b4};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
	
	//Returns the value of the control variable
	public static boolean getClap(){
		return clapped;
	}
	
	//Sets the control variable to true
	public static void setClap(){
		clapped = true;
	}
}
