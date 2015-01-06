/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Scott
 */
public class SensorSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Encoder rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_P1,RobotMap.RIGHT_ENCODER_P2,false, CounterBase.EncodingType.k4X);
    public Encoder leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_P1,RobotMap.LEFT_ENCODER_P2, true, CounterBase.EncodingType.k4X);
    
    public double ftperpulseright = (6./8118.);
    public double ftperpulseleft = (6./8227.);
        
    double pulsesperrev = (700./3.)*(4.*RobotMap.PI/12.);
    
    public Gyro gyro = new Gyro(RobotMap.GYRO);
    public BuiltInAccelerometer accel = new BuiltInAccelerometer();
    
    public double calGyro = 0.0;
    public double calX = 0.0;
    public double calY = 0.0;
    
    public DigitalInput leftLightSensa = new DigitalInput(RobotMap.LEFT_PHOTO);
    public DigitalInput rightLightSensa = new DigitalInput(RobotMap.RIGHT_PHOTO);
    
    public AnalogInput ultrasonic = new AnalogInput(RobotMap.ULTRA_SONIC);
    
    public double driveBase = 19.5/12.;
    public long encoderStartTime;
    public double theta;
    public double x;
    public double y;
    public double adjustedY;
    
    public double leftSpeed;
    public double rightSpeed;
    public double diffSpeed;
    public double aveSpeed;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Sense());
    }
    public void initializeSensors(){
        //start up all the sensors
        rightEncoder.reset();
        leftEncoder.reset();

        rightEncoder.setDistancePerPulse(ftperpulseright);
        leftEncoder.setDistancePerPulse(ftperpulseleft);
        //gets 20 samples and then averages them and subtracts out gravity
        for( double i = 0; i<20; i++){
            calX+=accel.getX();
            calGyro+=gyro.getRate();
        }
        //gets 20 samples and then averages them and subtracts out gravity
        for( double j = 0; j<20; j++){
            calY+=accel.getY();
            calGyro+=gyro.getRate();
        }
        
        calX/=20.;
        calY/=20.;
        calGyro/=40.;
    }
    
    public void sense(){
        //prints stuff
        SmartDashboard.putNumber("Right raw:", rightEncoder.getRaw());
        //SmartDashboard.putNumber("Right Distance(ft):", rightEncoder.getDistance()*(2.395/.25));
        //SmartDashboard.putNumber("Right Distance(ft):", rightEncoder.getDistance()*((25.2/12.)/2.1)*(5.4167/5.484));

                
        SmartDashboard.putNumber("Right Distance(ft):", rightEncoder.getRaw()*ftperpulseright);
        
        SmartDashboard.putNumber("Left raw:", leftEncoder.getRaw());
        //SmartDashboard.putNumber("Left Distance(ft):", leftEncoder.getDistance()*(2.395/.25));
        SmartDashboard.putNumber("Left Distance(ft):", leftEncoder.getRaw()*ftperpulseleft);
        
//        SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
        SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
//        
//        SmartDashboard.putNumber("X", accel.getAccelerations().XAxis - calX);
//        SmartDashboard.putNumber("Y", accel.getAcceleration(ADXL345_I2C.Axes.kY) - calY);
//        SmartDashboard.putNumber("Z", accel.getAcceleration(ADXL345_I2C.Axes.kZ));
//        
        SmartDashboard.putBoolean("leftphotosensa", leftLightSensa.get());
        SmartDashboard.putBoolean("rightphotosensa", rightLightSensa.get());
        
        //SmartDashboard.putNumber("ultrasonic", ultrasonic.getVoltage()/(.0048828125*100));
        //SmartDashboard.putNumber("ultrasonic", ultrasonic.getAverageVoltage());
    }
    
    public void reset(){
        //reset all the sensors
        rightEncoder.reset();
        leftEncoder.reset();
        gyro.reset();
        encoderStartTime = System.currentTimeMillis()/1000l;
    }
    
    public void deadReckon(){
        //long time =  System.currentTimeMillis()/1000l - encoderStartTime;
        leftSpeed = leftEncoder.getRate()*((25.2/12.)/2.1);
        rightSpeed = rightEncoder.getRate()*((25.2/12.)/2.1);
        diffSpeed = (rightSpeed-leftSpeed);
        aveSpeed = (rightSpeed+leftSpeed)/2.;
//        if(-.001<diffSpeed && diffSpeed<0.001){
//            diffSpeed+=.002;
//        }
        if(diffSpeed==0){
            diffSpeed=.001;
        }
        double num = ((driveBase*aveSpeed)/(diffSpeed));
        theta = (90.-gyro.getAngle())*(RobotMap.PI/180.);
        //theta = (diffSpeed*time)/driveBase;
        x += (num)*(Math.sin(theta));
        y += -(num)*(Math.cos(theta)-1.);
        
        SmartDashboard.putNumber("encoder theta(degrees)", theta*180/RobotMap.PI);
        SmartDashboard.putNumber("x distance (ft)", x);
        SmartDashboard.putNumber("y distance (ft)", y);
    }
    
}
