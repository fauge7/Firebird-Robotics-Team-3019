package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	@Override
	protected void initDefaultCommand() {
		
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveArcade());
	}

}
