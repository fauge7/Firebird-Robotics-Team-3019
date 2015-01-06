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
public class AutoDist extends Command {
    
    public AutoDist() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.train);
        requires(Robot.sensorsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //driveDistance = SmartDashboard.getNumber("driveDistance");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.train.driveTank(.7, .7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.sensorsystem.rightEncoder.getRaw()*(10./13828.) > (Robot.train.DISTANCETOTRAVELINFT + Robot.oi.stick.getThrottle()*0));
        //Robot.train.driveDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.train.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
