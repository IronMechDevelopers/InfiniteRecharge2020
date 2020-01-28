/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.Drivetrain;

/**
 * Add your docs here.
 */
public class RobotContainer {
    private final Drivetrain m_robotDrive = new Drivetrain();
    
    private final Joystick driverLeftStick = new Joystick(1);
    private final Joystick driveRightStick = new Joystick(2);

    public RobotContainer() {

    
        // Configure default commands
        // Set the default drive command to split-stick arcade drive
        m_robotDrive.setDefaultCommand(
            // A split-stick arcade command, with forward/backward controlled by the left
            // hand, and turning controlled by the right.
            new RunCommand(() -> m_robotDrive
                .arcadeDrive(driverLeftStick.getY(),
                driveRightStick.getX()), m_robotDrive));
      }

	public Command getAutonomousCommand() {
		return new InstantCommand();
	}

}
