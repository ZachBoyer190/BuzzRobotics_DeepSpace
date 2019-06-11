/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  public static Lift lift = null;

  TalonSRX front, rear;

  public Lift() {
    front = new TalonSRX(RobotMap.FRONT_LIFT);
    rear = new TalonSRX(RobotMap.REAR_LIFT);

    addChild(front);
    addChild(rear);
  }

  public static Lift getInstance() {
    if (lift == null)
      lift = new Lift();
    return lift;
  }

  public void liftFront(ControlMode mode, double speed) {
    front.set(mode, speed);
  }

  public void liftRear(ControlMode mode, double speed) {
    rear.set(mode, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
