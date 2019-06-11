/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  /** CAN Assignments **/
  public final static int LEFT_MASTER = 1,
                          LEFT_SLAVE = 2,
                          RIGHT_MASTER = 3,
                          RIGHT_SLAVE = 4,
                          LATERAL = 5,
                          ELEVATOR = 6,
                          FRONT_LIFT = 7,
                          REAR_LIFT = 8;
  
  /** Solenoids **/
  public final static int LATERAL_SOLENOID_FWD = 1,
                          LATERAL_SOLENOID_REV = 2;

  /** PID Configurations */
  public final static int PID_X = 0,
                          TIMEOUT_MS = 0;

  /** PID Constants **/
  public final static int ELEVATOR_KP = 1;
}
