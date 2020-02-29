/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ekim;

public class KeepBallsIn extends CommandBase {

  public Ekim ekim;
  public long time;
  public KeepBallsIn(Ekim ekim) {
    super();
    this.ekim = ekim;
    addRequirements(ekim);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    time=System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    this.ekim.runBackwards(.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.ekim.runBackwards(0);
  }


  
}
