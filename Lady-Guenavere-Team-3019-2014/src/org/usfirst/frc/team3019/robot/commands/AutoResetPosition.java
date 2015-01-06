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
public class AutoResetPosition extends Command {
    double straightLeft;
    double straightRight;
    public AutoResetPosition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.train);
        requires(Robot.sensorsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        straightLeft = .3;
        straightRight = .3;
        Robot.sensorsystem.adjustedY = Robot.oi.stick.getThrottle()*5.;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.sensorsystem.y<Robot.sensorsystem.adjustedY){
            Robot.train.driveTank(straightLeft, straightRight);
        }else{
            Robot.train.driveTank(-straightLeft, -straightRight);
        }
        
        if(Robot.sensorsystem.gyro.getAngle()>0.1 || (Robot.sensorsystem.leftEncoder.getRaw()>Robot.sensorsystem.rightEncoder.getRaw())){
            straightLeft-=.02;
            straightRight+=.02;
        }else if(Robot.sensorsystem.gyro.getAngle()<.1 || (Robot.sensorsystem.leftEncoder.getRaw()<Robot.sensorsystem.rightEncoder.getRaw())){
            straightLeft+=.02;
            straightRight-=.02;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.sensorsystem.y-Robot.sensorsystem.adjustedY)<.1;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
