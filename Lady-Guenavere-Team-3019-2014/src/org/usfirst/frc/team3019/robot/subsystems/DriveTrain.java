/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.DriveArcade;

//import static FIRST.Team3019.commands.CommandBase.train;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Developer
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Talon leftfrontmotor = new Talon(RobotMap.LEFT_FRONT_M);
    public Talon leftrearmotor = new Talon(RobotMap.LEFT_BACK_M);
    public Talon rightfrontmotor = new Talon(RobotMap.RIGHT_FRONT_M);
    public Talon rightrearmotor = new Talon(RobotMap.RIGHT_BACK_M);
    //public Talon leftMotor = new Talon(3);
    //public Talon rightMotor = new Talon(4);
    
    public RobotDrive train = new RobotDrive(leftfrontmotor, leftrearmotor, rightfrontmotor, rightrearmotor);
    //public RobotDrive train = new RobotDrive(leftMotor, rightMotor); 
    
    public double DISTANCETOTRAVELINFT = 10.;
    //does this need to be in a method that runs periodically?
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveArcade());
        
    }
    
    public void driveArcade(double y, double rotation){
        //standard arcade drive. you know pacmans controls? that
        train.arcadeDrive(y, rotation);
        
    }
    
    public void driveTank(double left, double right){
        //drive like a tank commander
        train.tankDrive(left, right);
    }
    
    public void doNothing(){
        //set the speed of the motors
        train.arcadeDrive(0, 0);
    }
}

// INDIGO ROCKS // Method-xbox//; (0, 0)
