/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class RightGoToPos extends CommandBase {
  private final Drivetrain drivetrain;
  private final double distance;
  private double stop;

  public RightGoToPos(Drivetrain drivetrain, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.distance = distance;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stop = drivetrain.getRightTicks() + distance;
    drivetrain.setRightGoal(distance);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(drivetrain.getRightTicks() + "||||||||" + distance);
    
    drivetrain.setRightPosition(distance);
    drivetrain.log();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (drivetrain.getRightTicks() >= stop){
      return true;
    }
    return false;
  }
}
