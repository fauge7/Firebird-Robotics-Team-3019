package org.usfirst.frc.team3019.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//tallon motor controller channels
	
	//drive
		//4 motors
	public static final int Drive_Right_Front = 1;
	public static final int Drive_Right_Back = 2;
	public static final int Drive_Left_Front = 3;
	public static final int Drive_Left_Back = 4;
		//2 motors
	public static final int Drive_Left = 1;
	public static final int Drive_Right = 3;
	
	//other
	
	public static final boolean Using_Four_Motors = true;
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
