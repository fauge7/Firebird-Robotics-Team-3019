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
public class Turn extends Command {
    double turnLeft;
    double turnRight;
    public Turn() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.sensorsystem);
        requires(Robot.train);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.sensorsystem.reset();
        turnLeft = .4;
        turnRight = -.4;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.train.driveTank(turnLeft, turnRight);
        if(Math.abs(Robot.sensorsystem.leftEncoder.getRate())>Math.abs(Robot.sensorsystem.rightEncoder.getRate())){
            turnLeft -= .01;
            turnRight += .01;
        }else if((Math.abs(Robot.sensorsystem.leftEncoder.getRate())<Math.abs(Robot.sensorsystem.rightEncoder.getRate()))){
            turnLeft += .01;
            turnRight -=.01;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.sensorsystem.gyro.getAngle()>=150);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
