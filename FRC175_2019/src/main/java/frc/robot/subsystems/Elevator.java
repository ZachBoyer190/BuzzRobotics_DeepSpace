/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  public static Elevator elevator = null;

  private Position setpoint;

  private double elevSetpoint;

  TalonSRX elev;

  public Elevator() {
    elev = new TalonSRX(RobotMap.ELEVATOR);

    elev.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.PID_X, RobotMap.TIMEOUT_MS);
    elev.setSensorPhase(true);
    elev.setSelectedSensorPosition(0);

    elev.config_kP(RobotMap.PID_X, RobotMap.ELEVATOR_KP);
    elev.setNeutralMode(NeutralMode.Brake);
    elevSetpoint = Position.Ground.getPosition();
    setpoint = Position.Ground;
    
    addChild(elev);
  }

  public enum Position {

    Ground(0),
    LoadingHatch(5), HatchOne(7),
    CargoShipCargo(20), RocketHatchTwo(37), RocketHatchThree(66), RocketCargoOne(22), RocketCargoTwo(51),
    RocketCargoThree(81), MaximumHeight(80);

    private int inches;

    private Position(int inches){
      this.inches = inches;
    }

    public int getPosition() {
      return inches;
    }

  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
