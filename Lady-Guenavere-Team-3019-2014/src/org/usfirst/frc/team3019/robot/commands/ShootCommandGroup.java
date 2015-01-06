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
public class ShootCommandGroup extends CommandGroup {
    
    public ShootCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        addSequential(new SetShootBooleans(), .1);
        addSequential(new Latch(),.5);
        addSequential(new SwitchTensionBoolean(),.1);
        addSequential(new Tension(),2.5);
        addSequential(new SwitchLatchBoolean(),.1);
        addSequential(new Latch(),.4);
        addSequential(new SwitchTensionBoolean(),.1);
        addParallel(new Tension(),.8);
        //addParallel(new AutoBack(),1.);
        //addParallel(new AutoForwardMore(),.35);
        //addParallel(new LoadersUp(),.4);
        //addParallel(new LoaderSpin(), 5.);
        
        
        
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
