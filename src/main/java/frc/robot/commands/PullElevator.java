/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants.ElevatorPullerConstants;
import frc.robot.subsystems.ElevatorPuller;

public class PullElevator extends CommandBase {
  
  private final ElevatorPuller puller;
  private long time;

  public PullElevator(final ElevatorPuller puller) {
    super();
    this.puller = puller;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    time=System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    this.puller.runForward(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(System.currentTimeMillis()>=time+ElevatorPullerConstants.runTime)
    return true;
    else
    return false;
  }

  // // Called once after isFinished returns true
  // @Override
  // public void end() {
  //   this.puller.runForward(0);
  // }

  // // Called when another command which requires one or more of the same
  // // subsystems is scheduled to run
  // @Override
  // public void interrupted() {

  // }

  
}
