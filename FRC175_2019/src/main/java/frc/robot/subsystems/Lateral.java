/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lateral extends Subsystem {
  private static Lateral lDrive = null;

  //private final int LATERAL = 5, LATERAL_SOLENOID_FWD = 1, LATERAL_SOLENOID_REV = 2;

  TalonSRX lateralDrive;
  DoubleSolenoid lateralDrop;

  public Lateral() {
    lateralDrive = new TalonSRX(RobotMap.LATERAL);
    lateralDrop = new DoubleSolenoid(RobotMap.LATERAL_SOLENOID_FWD, RobotMap.LATERAL_SOLENOID_REV);

    addChild(lateralDrive);
    addChild(lateralDrop);
  }

  public static Lateral getInstance() {
    if (lDrive == null)
      lDrive = new Lateral();
    return lDrive;
  }

  public void drive(ControlMode mode, double speed){
    lateralDrive.set(mode, speed);
  }

  public void deploy(){
    lateralDrop.set(Value.kForward);
  }

  public void retract(){
    lateralDrop.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new DefaultLateral());
  }
}
