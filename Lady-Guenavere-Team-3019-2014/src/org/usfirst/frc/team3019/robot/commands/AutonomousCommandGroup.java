/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Scott
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public AutonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        //addSequential(new HasRunCheck(),1);
        //addSequential(new See(), 15);
        //addSequential(new HasRunCheck2(),1);
        //        while(!vision.Hot){
//            if(10000.<System.currentTimeMillis()-Robot.autotime){
//                break;
//            }
//        } 
        
        addSequential(new ResetSensors());
        addSequential(new LoadOutPotent(),1);
        addSequential(new AutoDist());
        addSequential(new LoadOutPotent2(),1);
        addSequential(new ShootCommandGroup());
        addParallel(new LoadOutPotent(),1);
        //addParallel(new LoadUp());
        addParallel(new LoaderSpin(),3);
        addSequential(new AutoBackDist());
        
//        addSequential(new LoaderOut(),.2);
//        addSequential(new AutoDist2(),2.);
//        
//        addSequential(new LoaderOut(),.05);
//        addSequential(new ShootCommandGroup());
        //adjust AutoForwardMore to Encoder distance, ultrasonic distance, accelerometer dist, or camera dist
        
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
