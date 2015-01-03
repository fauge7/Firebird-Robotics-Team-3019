package org.usfirst.frc.team3019.robot.subsystems;


import org.usfirst.frc.team3019.robot.Robot;
import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	//variables for 4 motor drive
	Talon Drive_Right_Front;
	Talon Drive_Right_Back;
	Talon Drive_Left_Front;
	Talon Drive_Left_Back;
	//variables used for 2 motor drive
	Talon Drive_Right;
	Talon Drive_Left;
	
	RobotDrive drive;
	
	public DriveTrain() {
		// TODO Auto-generated constructor stub
		if(RobotMap.Using_Four_Motors){
			Drive_Right_Front = new Talon(RobotMap.Drive_Right_Front);
			Drive_Right_Back = new Talon(RobotMap.Drive_Right_Back);
			Drive_Left_Front = new Talon(RobotMap.Drive_Left_Front);
			Drive_Left_Back = new Talon(RobotMap.Drive_Left_Back);
			drive = new RobotDrive(Drive_Left_Front, Drive_Left_Back, Drive_Right_Front, Drive_Right_Back);
		}
		else{
			Talon Drive_Right = new Talon(RobotMap.Drive_Right);
			Talon Drive_Left = new Talon(RobotMap.Drive_Left);
			drive = new RobotDrive(Drive_Left, Drive_Right);
		}
	}
	@Override
	protected void initDefaultCommand() {
		
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveArcade());
	}
	public void arcadeDrive(){
		drive.arcadeDrive(Robot.oi.drive.getX(), Robot.oi.drive.getZ());
	}
}