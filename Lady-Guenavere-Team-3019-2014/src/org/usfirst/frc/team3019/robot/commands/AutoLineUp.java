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
public class AutoLineUp extends Command {
    double speed;
    public AutoLineUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.train);
        requires(Robot.sensorsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.sensorsystem.initializeSensors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if(Robot.sensorsystem.rightLightSensa.get()){
            
            Robot.train.driveTank(speed, .7);
            if (Robot.sensorsystem.leftEncoder.getRate()>0){
                speed-=.1;
            }else if(Robot.sensorsystem.leftEncoder.getRate()<-.25){
                speed+=.2;
            }
        }else if(Robot.sensorsystem.rightLightSensa.get()){
            Robot.train.driveTank(.7, speed);
            if (Robot.sensorsystem.rightEncoder.getRate()>0){
                speed-=.1;
            }else if(Robot.sensorsystem.rightEncoder.getRate()<-.25){
                speed+=.2;
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return (Robot.sensorsystem.leftLightSensa.get() && Robot.sensorsystem.rightLightSensa.get());
    }

    // Called once after isFinished returns true
    public void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
