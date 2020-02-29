/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants.ElevatorConstants;
import frc.robot.subsystems.Elevator;

public class ElevatorDown extends CommandBase {
  private Elevator elevator;
  private long time;
  public ElevatorDown(Elevator elevator) {
    // Use addRequirements() here to declare subsystem dependencies.
      this.elevator=elevator;
      addRequirements(this.elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.elevator.runBackwards(ElevatorConstants.elevatorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.elevator.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(System.currentTimeMillis()>=time+ElevatorConstants.runTime)
    return true;
    else
    return false;
  }
}
