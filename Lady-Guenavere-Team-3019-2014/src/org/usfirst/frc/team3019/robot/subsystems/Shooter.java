
package org.usfirst.frc.team3019.robot.subsystems;


import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.Latch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //DoubleSolenoid soli = new Solenoid(1);
    public DoubleSolenoid ReleasePiston = new DoubleSolenoid(RobotMap.DOUBLE_SOLE_LATCH_1,RobotMap.DOUBLE_SOLE_LATCH_2);
    
    public boolean isLatched = true;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Latch());
    }
    
    public void switchup(){
        //switches isLatched to true

        if(isLatched){
            isLatched = false;
        }else{
            isLatched = true;
        }
    }
}

