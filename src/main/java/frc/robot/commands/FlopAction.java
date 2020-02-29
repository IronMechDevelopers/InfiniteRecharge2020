/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Constants.DriveConstants.FlopperConstants;
import frc.robot.subsystems.Flopper;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlopAction extends CommandBase {
  /**
   * Creates a new FlopAction.
   */

   private Flopper flopper;
   private long time;
   
  public FlopAction(Flopper flopper) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    this.flopper=flopper;
    addRequirements(flopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time=System.currentTimeMillis();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    flopper.deploy(.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    flopper.deploy(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(System.currentTimeMillis()>=time+FlopperConstants.runTime)
    return true;
    else
    return false;
  }
}
