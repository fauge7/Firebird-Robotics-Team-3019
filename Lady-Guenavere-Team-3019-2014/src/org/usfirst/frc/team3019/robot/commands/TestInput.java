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
 * @author Suzanne
 */
public class TestInput extends Command {
    
    public TestInput() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.loada);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double smartInput = SmartDashboard.getNumber("smartInput:");
        setTimeout(smartInput);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.loada.spin(.5);
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
