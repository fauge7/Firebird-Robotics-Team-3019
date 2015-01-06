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
public class AutoRotate extends Command {
    double speed;
    public AutoRotate() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.sensorsystem);
        requires(Robot.train);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double angle = Robot.sensorsystem.gyro.getAngle();
        if(angle>0){
            Robot.train.driveTank(speed, angle);
        }
        
        
        if(angle>3){
            
            Robot.train.driveTank(speed, .4);
            if (Robot.sensorsystem.leftEncoder.getRate()>0){
                speed-=.1;
            }else if(Robot.sensorsystem.leftEncoder.getRate()<-.25){
                speed+=.2;
            }
        }else if(angle<-3){
            Robot.train.driveTank(.4, speed);
            if (Robot.sensorsystem.rightEncoder.getRate()>0){
                speed-=.1;
            }else if(Robot.sensorsystem.rightEncoder.getRate()<-.25){
                speed+=.2;
            }
        }else if(-3<angle && angle<0){
            Robot.train.driveTank(.2, -.2);
        }else if(0<angle && angle<3){
            Robot.train.driveTank(-.2,.2);
        }else{
            Robot.train.driveTank(0,0);
        }
            
    }

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
    }
}
