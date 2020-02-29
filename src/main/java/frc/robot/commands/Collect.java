/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class Collect extends CommandBase {
  private Collector flopper;
  /**
   * Creates a new collect.
   */
  public Collect(Collector flopper) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    this.flopper = flopper;
    addRequirements(flopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    flopper.collect();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    flopper.stopCollect();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
