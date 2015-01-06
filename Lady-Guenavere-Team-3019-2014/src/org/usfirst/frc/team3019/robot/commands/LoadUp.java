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
public class LoadUp extends Command {
    
    public LoadUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.loada);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.loada.LoaderHeight.set(-.4);
        SmartDashboard.putBoolean("Loader limit:", Robot.loada.LoaderLimit.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.loada.LoaderLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        SmartDashboard.putBoolean("Loader limit:", Robot.loada.LoaderLimit.get());
        double originalVoltage = 3.593;
        //angle=135
        Robot.loada.VoltageChange = Robot.loada.Potent.getAverageVoltage() - originalVoltage;
        SmartDashboard.putNumber("VoltageChange", Robot.loada.VoltageChange);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
