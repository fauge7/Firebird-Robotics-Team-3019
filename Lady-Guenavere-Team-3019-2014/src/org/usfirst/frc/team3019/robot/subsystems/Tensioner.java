/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.Tension;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Scott
 */
public class Tensioner extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DoubleSolenoid TensionPiston = new DoubleSolenoid(RobotMap.DOUBLE_SOLE_TENSION_1,RobotMap.DOUBLE_SOLE_TENSION_2);
            
    public boolean isTensioned = false;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Tension());
    }
    
    public void switchup(){
        //switches the istensioned to true
        if(isTensioned){
            isTensioned = false;
        }else{
            isTensioned = true;
        }
    }
    
}

