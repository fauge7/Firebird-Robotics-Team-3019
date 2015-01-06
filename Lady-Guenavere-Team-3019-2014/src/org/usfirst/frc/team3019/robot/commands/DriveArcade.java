/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 *
 * @author Scott
 */
public class DriveArcade extends Command {
    

    public DriveArcade() {

        // Use requires() here to declare subsystem dependencies
        requires(Robot.train);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Joystick driveStick = oi.stick;
        //double y = driveStick.getY();
        //double rotation = driveStick.getZ();
        Robot.train.driveArcade(-Robot.oi.stick.getY(), -Robot.oi.stick.getZ() * .8);
        SmartDashboard.getNumber("Throttle",Robot.oi.stick.getThrottle());
    
    }
    // Make this return true whe

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.train.doNothing();
    }
}
