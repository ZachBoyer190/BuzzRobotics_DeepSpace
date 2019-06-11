/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.drive.DefaultLateral;
import frc.robot.commands.lift.LiftFront;
import frc.robot.commands.lift.RetractFront;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final int LEFT_STICK = 0, RIGHT_STICK = 1;

  private Joystick leftStick, rightStick;

  private JoystickButton lateral, liftFront, retractFront;

  OI() {
    leftStick = new Joystick(LEFT_STICK);
    rightStick = new Joystick(RIGHT_STICK);


    /**** Driver Stick Buttons *****/
    lateral = new JoystickButton(leftStick, 1);
    lateral.whileHeld(new DefaultLateral());

    liftFront = new JoystickButton(leftStick, 2);
    liftFront.whileHeld(new LiftFront());

    retractFront = new JoystickButton(leftStick, 3);
    retractFront.whileHeld(new RetractFront());

    /**** Operator Stick Buttons  ****/

  }

  public double getLeftX(){
    return leftStick.getX();
  }

  public double getLeftY(){
    return leftStick.getY();
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

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
