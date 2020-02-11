/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;

/**
 * Add your docs here.
 */
public class RobotContainer {
    private final Drivetrain m_robotDrive = new Drivetrain();
    private final Shooter m_shooter = new Shooter();

    private final Joystick driverLeftStick = new Joystick(1);
    private final Joystick driveRightStick = new Joystick(2);

    public RobotContainer() {
        // Configure default commands
        m_robotDrive.setDefaultCommand(new Drive(() -> driverLeftStick.getY(Hand.kLeft),
                () -> driveRightStick.getX(Hand.kRight), m_robotDrive));

        // Configure the button bindings
        configureButtonBindings();
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        final JoystickButton shooterUp = new JoystickButton(driverLeftStick, 5);
        final JoystickButton shooterDown = new JoystickButton(driverLeftStick, 4);


        shooterUp.whenPressed(new Shoot(m_shooter));

    }
}
