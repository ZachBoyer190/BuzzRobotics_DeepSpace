/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.drive.DefaultDrive;


public class Drive extends Subsystem {

  private static Drive drive = null;

  PairedTalonSRX leftPair, rightPair;

  public Drive() {
    leftPair = new PairedTalonSRX(RobotMap.LEFT_MASTER, RobotMap.LEFT_SLAVE);
    rightPair = new PairedTalonSRX(RobotMap.RIGHT_MASTER, RobotMap.RIGHT_SLAVE);

    leftPair.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.PID_X, RobotMap.TIMEOUT_MS);
    rightPair.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.PID_X, RobotMap.TIMEOUT_MS);

    leftPair.setSensorPhase(true);
    rightPair.setSensorPhase(true);
    leftPair.setSelectedSensorPosition(0);
    rightPair.setSelectedSensorPosition(0);

    addChild(leftPair);
    addChild(rightPair);
    addChild(leftPair.getFollower());
    addChild(rightPair.getFollower());

  }

  public static Drive getInstance(){
    if (drive == null)
      drive = new Drive();
    return drive;
  }

  public void setCoast() {
    leftPair.setNeutralMode(NeutralMode.Coast);
    rightPair.setNeutralMode(NeutralMode.Coast);
  }

  public void setBrake() {
    leftPair.setNeutralMode(NeutralMode.Brake);
    rightPair.setNeutralMode(NeutralMode.Brake);
  }

  public void drive(ControlMode mode, double left, double right){
    leftPair.set(mode, left);
    rightPair.set(mode, right);
  }

  public int getLeftPosition() {
    return leftPair.getSelectedSensorPosition(RobotMap.PID_X);
  }

  public int getRightPosition() {
    return rightPair.getSelectedSensorPosition(RobotMap.PID_X);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DefaultDrive());
  }
}
