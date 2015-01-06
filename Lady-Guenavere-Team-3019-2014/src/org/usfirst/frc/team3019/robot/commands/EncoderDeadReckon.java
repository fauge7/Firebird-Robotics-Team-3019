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
public class EncoderDeadReckon extends Command {
    
    public EncoderDeadReckon() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.train);
        requires(Robot.sensorsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.sensorsystem.leftEncoder.reset();
        Robot.sensorsystem.rightEncoder.reset();
        Robot.sensorsystem.encoderStartTime = (System.currentTimeMillis()/1000l);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.sensorsystem.deadReckon();
        if(Robot.oi.resetButton.get()){
            Robot.sensorsystem.reset();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!Robot.oi.deadReckonModeToggle.get());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
