/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Scott
 */
public class LoaderIn extends Command {
    
    public LoaderIn() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.loada);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //loada.outLoaderPosition(RobotMap.PICKUPANGLE);
        Robot.loada.raiseLoader(-.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
