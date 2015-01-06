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
    
    public static final double PI = Math.PI;
    public static final double PICKUPANGLE = 60.;
    //Joysticks
    //J1
    public static final int RIGHT_JOYSTICK = 1;
    //Buttons - J1
    public static final int RESET_BUTTON = 2;
    public static final int AUTO_DIST_TOGGLE = 7;
    public static final int DRIVE_STRAIGHT_TOGGLE = 8;
    public static final int SENSE_TOGGLE = 9;
    public static final int DEAD_RECKON_MODE_TOGGLE = 10;
    public static final int STRAIGHTEN_MODE_TOGGLE = 11;
    public static final int REBOUND_MODE_TOGGLE = 12;
    //J3
    public static final int XBOX_JOYSTICK = 3;
    //Buttons - J3
    public static final int SHOOT_BUTTON = 1;
    public static final int TENSION_BUTTON = 2;
    public static final int RESET_SENSORS_BUTTON = 3;
    public static final int LATCH_BUTTON = 4;
    public static final int LOAD_OUT_BUTTON = 6;
    
    
    //Digital IO's
    public static final int LEFT_ENCODER_P1 = 1;
    public static final int LEFT_ENCODER_P2 = 2;
    public static final int RIGHT_ENCODER_P1 = 3;
    public static final int RIGHT_ENCODER_P2 = 4;
    public static final int LEFT_PHOTO = 5;
    public static final int RIGHT_PHOTO = 6;
    public static final int LOADER_LIMIT_SWITCH = 8;
    public static final int PRESSURE_SWITCH = 10;
    
    
    //Relays
    public static final int COMPRESSOR_RELAY = 2;
    
    //Motors
    public static final int LEFT_FRONT_M = 1;
    public static final int LEFT_BACK_M = 2;
    public static final int RIGHT_FRONT_M = 3;
    public static final int RIGHT_BACK_M = 4;
    public static final int LOADER_HEIGHT = 5;
    public static final int LEFT_LOADER_SPIN = 7;
    public static final int RIGHT_LOADER_SPIN = 8;
    
    //Analog Inputs
    public static final int GYRO = 1;
    public static final int ULTRA_SONIC = 3;
    public static final int POTENT = 5;
    
    //Pneumatic Inputs
    public static final int DOUBLE_SOLE_LATCH_1 = 1;
    public static final int DOUBLE_SOLE_LATCH_2 = 2;
    public static final int DOUBLE_SOLE_TENSION_1 = 3;
    public static final int DOUBLE_SOLE_TENSION_2 = 4;
    
}