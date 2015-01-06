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
public class MoveLoader extends Command {
    	double loaderCounter;
    	double speed;
    public MoveLoader() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.loada);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        loaderCounter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.loada.spin(Robot.oi.xbox.getZ());
        if(Robot.oi.xbox.getY()>.2){
            speed = 1;
        }else if(Robot.oi.xbox.getY()<-.2){
            speed = -1;
        }else{
            speed = 0;
        }
        Robot.loada.raiseLoader(speed);
//        loaderCounter+=1;
//        if(loaderCounter%10==0){
//            Robot.loada.makeConsistent();
//        }
        //220/18
        //SmartDashboard.putBoolean("trueleft", Robot.loada.leftLoaderLimit.get());
        //SmartDashboard.putBoolean("trueright", Robot.loada.rightLoaderLimit.get());
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
