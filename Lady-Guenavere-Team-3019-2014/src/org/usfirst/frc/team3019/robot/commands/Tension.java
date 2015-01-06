/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Scott
 */
public class Tension extends Command {
    
    public Tension() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.tensioner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {       
        SmartDashboard.putBoolean("isTensioner in tension:", Robot.tensioner.isTensioned);
         
        if(Robot.tensioner.isTensioned){
//            double startwait = System.currentTimeMillis()/1000;
//            double wait = 0;
            Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kOff);
//            while(wait<.1){
//               Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kOff);
//               wait = System.currentTimeMillis()/1000. - startwait;
//            }
            Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kForward);
        }else{
//            double startwait = System.currentTimeMillis()/1000;
//            double wait = 0;
            Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kOff);
//            while(wait<.1){
//               Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kOff);
//               wait = System.currentTimeMillis()/1000. - startwait;
//            }
            Robot.tensioner.TensionPiston.set(DoubleSolenoid.Value.kReverse);
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
