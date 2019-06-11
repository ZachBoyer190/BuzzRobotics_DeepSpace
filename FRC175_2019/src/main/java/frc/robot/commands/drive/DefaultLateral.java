/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DefaultLateral extends Command {
  public DefaultLateral() {
    requires(Robot.lateral);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive.drive(ControlMode.PercentOutput, 0, 0);
    Robot.lateral.deploy();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = Robot.m_oi.getLeftX();
    Robot.lateral.drive(ControlMode.PercentOutput, speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lateral.drive(ControlMode.PercentOutput, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
