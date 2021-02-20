/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class FollowPath extends CommandBase {
  private final Drivetrain drivetrain;
  private final double[] path;
  int part = 0;

  public FollowPath(final Drivetrain drivetrain, final double[] path) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.path = path;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.setVelocity(path[part], path[part + 1]);
    drivetrain.log();
    part += 2;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    drivetrain.setVelocity(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (part + 1 >= path.length);
  }
}
