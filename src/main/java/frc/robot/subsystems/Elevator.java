/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.DriveConstants.ElevatorConstants;


public class Elevator extends UnifiedMotorController {
  /**
   * Creates a new ReplaceMeSubsystem.
   */
  public Elevator (){
    super();
    setConstant(ElevatorConstants.elevatorMotor);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
