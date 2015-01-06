/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3019.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Scott
 */
public class AutoStraightenGroup extends CommandGroup {
    
    public AutoStraightenGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        
        //set constant iterations method
        
        long starttime;
        long phototime;
        addSequential(new AutoForward());
        starttime = System.currentTimeMillis();
        addSequential(new AutoLineUp());
        phototime = System.currentTimeMillis() - starttime;
        addSequential(new AutoBack(),.5);
        
        //kinda random function
        int num;
        if(phototime<1.){
            num = 0;
        }else if(1.<phototime && phototime<400.){
            num = 1;
        }else if(400.<phototime && phototime<1000.){
            num=2;
        }else{
            num=3;
        }
        SmartDashboard.putNumber("phototime(ms)", phototime);
        
        for(int i = 0; i < num; i++){
            addSequential(new AutoForward());
            addSequential(new AutoLineUp());
            addSequential(new AutoBack(),.5);
        }
        
        addSequential(new ResetSensors());
        //addParallel(new EncoderDeadReckon());
        addSequential(new AutoForwardMore());
        addSequential(new ShootCommandGroup());
        

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
