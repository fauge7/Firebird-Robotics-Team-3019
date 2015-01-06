/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.MoveLoader;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Scott
 */
public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    //instantizes the talons and sensors
    public Talon leftLoaderSpin = new Talon(RobotMap.LEFT_LOADER_SPIN);
    public Talon rightLoaderSpin = new Talon(RobotMap.RIGHT_LOADER_SPIN);
    
    //public Talon leftLoaderHeight = new Talon(RobotMap.LEFT_LOADER_HEIGHT);
    //public Talon rightLoaderHeight = new Talon(RobotMap.RIGHT_LOADER_HEIGHT);
    public Talon LoaderHeight = new Talon(RobotMap.LOADER_HEIGHT);
    
    public AnalogInput Potent = new AnalogInput(RobotMap.POTENT);
    
    public DigitalInput LoaderLimit = new DigitalInput(RobotMap.LOADER_LIMIT_SWITCH);
    
    public double VoltageChange;
    
    public double spintime=5;
    
    
    
    public void initDefaultCommand() {
        // Set the default  fcommandor a subsystem here.
        setDefaultCommand(new MoveLoader());
    }
    //spins the loada
    public void spin(double speed){
        leftLoaderSpin.set(speed);
        rightLoaderSpin.set(-speed);
        
    }
    //articulates the arms 
    public void raiseLoader(double speed){
        LoaderHeight.set(.7*speed);
        if(LoaderLimit.get() && speed<0){
            LoaderHeight.set(0);
            //double originalVoltage = 2.29007;
            //angle=135
            //leftVoltageChange = leftPotent.getAverageVoltage() - originalVoltage;
        }
        
        
        double PotV = Potent.getAverageVoltage();
        
        SmartDashboard.putNumber("PotV", PotV);
        
        SmartDashboard.putNumber("LoaderAngle", findLoaderAngle(PotV));
    }
    //makes them the same angle
    
//    public void makeConsistent(){
//        double diff = findLeftLoaderAngle(leftPotent.getAverageVoltage())-findRightLoaderAngle(rightPotent.getAverageVoltage());
//        if(diff>2.){
//            leftLoaderHeight.set(.3);
//            rightLoaderHeight.set(.3);
//        }else if(diff<-2.){
//            rightLoaderHeight.set(-.3);
//            leftLoaderHeight.set(-.3);
//        }else{
//            rightLoaderHeight.set(0);
//            leftLoaderHeight.set(0);
//        }
//    }
    
    public double findLoaderAngle(double voltage){
        double LoaderAngle;
        LoaderAngle = 491.539333;
        LoaderAngle -= 100.3660194 * (voltage - VoltageChange);
        return LoaderAngle;
    }
    
//    public double findLeftLoaderAngle(double voltage){
//        double leftLoaderAngle;
//        leftLoaderAngle = 910.42779535094;
//        leftLoaderAngle += -338.60415376823 * (voltage - leftVoltageChange);
//        return leftLoaderAngle;
//    }
    
    public void outLoaderPosition(double angle){
        double potAngle = findLoaderAngle(Potent.getAverageVoltage());
        if(potAngle-angle > 2.){
            LoaderHeight.set(.3);
        }else if(potAngle - angle < -3.){
            LoaderHeight.set(-.3);
        }else{
            LoaderHeight.set(0);
        }
    }

}