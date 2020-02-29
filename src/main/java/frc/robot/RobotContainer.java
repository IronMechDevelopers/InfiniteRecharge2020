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
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Ekim;
//import frc.robot.subsystems.Ekim;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.Drive;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.EverythingTest;
import frc.robot.commands.FlopAction;
import frc.robot.commands.Shoot;
import frc.robot.commands.Collect;
import frc.robot.commands.getColor;
import frc.robot.subsystems.Flopper;

/**
 * Add your docs here.
 */
public class RobotContainer {
    //all the subsstem
    private final Drivetrain m_robotDrive = new Drivetrain();
    private final Shooter m_shooter = new Shooter();
    private final Flopper flopperSubsystem = new Flopper();
    private final ColorSensor colorSensorSubsystem = new ColorSensor();
    private final Elevator elvatorSubsystem = new Elevator();
    private final Collector collectorSubsystem = new Collector();
    private final Ekim ekimSubsystem = new Ekim();
    //private final Ekim ekimSubsystem = new Ekim();

    private final Joystick driverLeftStick = new Joystick(0);
    private final Joystick driverRightStick = new Joystick(1);

    public RobotContainer() {
        // Configure default commands
        m_robotDrive.setDefaultCommand(new Drive(() -> driverLeftStick.getY(Hand.kLeft),
                () -> driverRightStick.getX(Hand.kRight), m_robotDrive));

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
        //all the buttons
        final JoystickButton shooterUp = new JoystickButton(driverLeftStick, 11);
        // final JoystickButton shooterDown = new JoystickButton(driverLeftStick, 4);
        // final JoystickButton flopActionButton = new JoystickButton(driverLeftStick, 6);
        final JoystickButton colorSensornButton = new JoystickButton(driverLeftStick, 7);
        final JoystickButton flopperOutButton = new JoystickButton(driverRightStick, 12);
        final JoystickButton suckBallButton = new JoystickButton(driverLeftStick, 3);
        final JoystickButton elevatorUpButton = new JoystickButton(driverLeftStick, 6);
        final JoystickButton elevatorDownButton = new JoystickButton(driverLeftStick, 4);

        final JoystickButton everythingBtton = new JoystickButton(driverRightStick, 1);


        //actions
        shooterUp.whenPressed(new Shoot(m_shooter));
        colorSensornButton.whileHeld(new getColor(colorSensorSubsystem));
        flopperOutButton.whenPressed(new FlopAction(flopperSubsystem));
        suckBallButton.whileHeld(new Collect(collectorSubsystem));
        elevatorUpButton.whileHeld(new ElevatorUp(elvatorSubsystem));
        elevatorDownButton.whileHeld(new ElevatorDown(elvatorSubsystem));

        everythingBtton.whileHeld(new EverythingTest(m_shooter,ekimSubsystem, collectorSubsystem));

    }
}
