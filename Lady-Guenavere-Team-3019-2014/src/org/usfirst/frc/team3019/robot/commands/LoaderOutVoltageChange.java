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
public class LoaderOutVoltageChange extends Command {
    
    public LoaderOutVoltageChange() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.loada);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //startLeftVoltage = loada.leftPotent.getAverageVoltage();
        //startRightVoltage = loada.rightPotent.getAverageVoltage();
        setTimeout(2.);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        double left = loada.leftPotent.getAverageVoltage();
//        double right = loada.rightPotent.getAverageVoltage();
//        
//        if(Math.abs(startLeftVoltage-left) < 15/(338.60415376823)){
//            loada.leftLoaderHeight.set(.3);
//        }
//        if(Math.abs(startRightVoltage-right) < 15/(309.2284374466)){
//            loada.rightLoaderHeight.set(-.3);
//        }
//        SmartDashboard.putNumber("leftPotV", left);
//        SmartDashboard.putNumber("rightPotV", right);
//        
//        SmartDashboard.putNumber("rightLoaderAngle", loada.findRightLoaderAngle(right));
//        SmartDashboard.putNumber("leftLoaderAngle", loada.findLeftLoaderAngle(left));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return ((Math.abs(startLeftVoltage-loada.leftPotent.getAverageVoltage()) < 15/(338.60415376823))
                //&&(Math.abs(startRightVoltage-loada.rightPotent.getAverageVoltage()) > 15/(309.2284374466 )))||(isTimedOut());
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
