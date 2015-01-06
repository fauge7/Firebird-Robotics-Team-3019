
package org.usfirst.frc.team3019.robot;

import org.usfirst.frc.team3019.robot.commands.AutoDist;
import org.usfirst.frc.team3019.robot.commands.AutoForwardMore;
import org.usfirst.frc.team3019.robot.commands.AutoReboundGroup;
import org.usfirst.frc.team3019.robot.commands.AutoStraightenGroup;
import org.usfirst.frc.team3019.robot.commands.ConsistifyLoader;
import org.usfirst.frc.team3019.robot.commands.EncoderDeadReckon;
import org.usfirst.frc.team3019.robot.commands.LoadOutPotent;
import org.usfirst.frc.team3019.robot.commands.LoadUp;
import org.usfirst.frc.team3019.robot.commands.LoaderOutVoltageChange;
import org.usfirst.frc.team3019.robot.commands.ResetSensors;
import org.usfirst.frc.team3019.robot.commands.Sense;
import org.usfirst.frc.team3019.robot.commands.ShootCommandGroup;
import org.usfirst.frc.team3019.robot.commands.SwitchLatchBoolean;
import org.usfirst.frc.team3019.robot.commands.SwitchTensionBoolean;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    
//Joystics
    public Joystick stick = new Joystick(1);
    public Joystick xbox = new Joystick(3);
//buttons
    //stick
    public Button resetButton = new JoystickButton(stick,RobotMap.RESET_BUTTON);
    public Button autoDistToggle = new JoystickButton(stick, RobotMap.AUTO_DIST_TOGGLE);
    public Button driveStraightToggle = new JoystickButton(stick, RobotMap.DRIVE_STRAIGHT_TOGGLE);
    public Button senseToggle = new JoystickButton(stick, RobotMap.SENSE_TOGGLE);
    public Button deadReckonModeToggle = new JoystickButton(stick, RobotMap.DEAD_RECKON_MODE_TOGGLE);
    public Button StraightenModeToggle = new JoystickButton(stick, RobotMap.STRAIGHTEN_MODE_TOGGLE);
    public Button ReboundModeToggle = new JoystickButton(stick, RobotMap.REBOUND_MODE_TOGGLE);
    
    //xbox
    public Button shootButton = new JoystickButton(xbox, 1);
    public Button consistifyLoaderButton = new JoystickButton(xbox, 2);
    public Button tensionButton = new JoystickButton(xbox,3);
    public Button latchButton = new JoystickButton(xbox, 4);
    public Button loadOutVoltageButton = new JoystickButton(xbox,7);
    public Button loaderResetButton = new JoystickButton(xbox, 8);
    public Button loadOutButton = new JoystickButton(xbox, RobotMap.LOAD_OUT_BUTTON);
    //public Button testButton = new JoystickButton(xbox, 7);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    //Button button = new DigitalIOButton(1);
    public OI(){
        autoDistToggle.whileHeld(new AutoDist());
        driveStraightToggle.whileHeld(new AutoForwardMore());
        senseToggle.whileHeld(new Sense());
        deadReckonModeToggle.whileHeld(new EncoderDeadReckon());
        tensionButton.whenReleased(new SwitchTensionBoolean());
        shootButton.whileHeld(new ShootCommandGroup());
        resetButton.whenPressed(new ResetSensors());
        latchButton.whenReleased(new SwitchLatchBoolean());
        StraightenModeToggle.whileHeld(new AutoStraightenGroup());
        ReboundModeToggle.whileHeld(new AutoReboundGroup());
        consistifyLoaderButton.whileHeld(new ConsistifyLoader());
        loaderResetButton.whileHeld(new LoadUp());
        loadOutButton.whileHeld(new LoadOutPotent());
        loadOutVoltageButton.whenReleased(new LoaderOutVoltageChange());
        //testButton.whenPressed(new TestInput());
    }
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

