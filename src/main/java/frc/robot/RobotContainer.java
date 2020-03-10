/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Welcome to Gary ver1.0.0

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Ekim;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.FineDrive;
import frc.robot.commands.RadTest;
import frc.robot.commands.ReadData;
import frc.robot.commands.SimpleAuto;
import frc.robot.commands.SimpleAutoWait;
import frc.robot.commands.StopEverything;
import frc.robot.commands.TurnOnMotor;
import frc.robot.subsystems.Flopper;

/**
 * Add your docs here.
 */
public class RobotContainer {

    
    //all the subsstem
    private final Drivetrain m_robotDrive = new Drivetrain();
    private final Shooter m_shooter = new Shooter();
    private final Flopper flopperSubsystem = new Flopper();
    private final Elevator elvatorSubsystem = new Elevator();
    private final Collector collectorSubsystem = new Collector();
    private final Ekim ekimSubsystem = new Ekim();

    private final Joystick driverLeftStick = new Joystick(0);
    private final Joystick driverRightStick = new Joystick(1);
    private final Joystick copilot = new Joystick (2);

    private SendableChooser<String> autoChooser = new SendableChooser<>();

    public RobotContainer() {

        SmartDashboard.putData("Stop Everything", new StopEverything(ekimSubsystem, flopperSubsystem, elvatorSubsystem,collectorSubsystem, m_shooter ));


        // Configure default commands
        m_robotDrive.setDefaultCommand(new Drive(() -> driverLeftStick.getY(Hand.kLeft),
                () -> driverRightStick.getX(Hand.kRight), m_robotDrive));
        m_shooter.setDefaultCommand(new ReadData(m_shooter));

        // Configure the button bindings
        configureButtonBindings();

        driverLeftStick.getZ();

            // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_robotDrive);
    SmartDashboard.putData(m_shooter);
    SmartDashboard.putData(flopperSubsystem);
    SmartDashboard.putData(elvatorSubsystem);
    SmartDashboard.putData(collectorSubsystem);
    SmartDashboard.putData(ekimSubsystem);

    autoChooser.setDefaultOption("Simple","A");
    autoChooser.addOption("Wait 1","B");
    autoChooser.addOption("Wait 2","C");
    autoChooser.addOption("Wait 3","D");
    autoChooser.addOption("Wait 4","E");
    autoChooser.addOption("Wait 5","F");
    SmartDashboard.putData("Auto Options", autoChooser);
    
    
    }

    public String getAuto()
    {
        return autoChooser.getSelected();
    }

    public Command getAutonomousCommand() {
        if(this.getAuto().equals("A"))
        {
            System.out.println("OPTION A");
            return new SimpleAuto(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem);
        }
        else if(this.getAuto().equals("B"))
        {
            System.out.println("OPTION B");
            return new SimpleAutoWait(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem,1);
        }
        else if(this.getAuto().equals("C"))
        {
            System.out.println("OPTION C");
            return new SimpleAutoWait(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem,2);
        }
        else if(this.getAuto().equals("D"))
        {
            System.out.println("OPTION D");
            return new SimpleAutoWait(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem,3);
        }
        else if(this.getAuto().equals("E"))
        {
            System.out.println("OPTION E");
            return new SimpleAutoWait(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem,4);
        }
        else if(this.getAuto().equals("F"))
        {
            System.out.println("OPTION F");
            return new SimpleAutoWait(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem,5);
        }
        else
        {
            System.out.println("Other");
            return new DriveStraight(m_robotDrive).withTimeout(3.5);
        }
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        //all the buttons
        final JoystickButton shooterOn = new JoystickButton(copilot, 1);
        final JoystickButton collectorOn = new JoystickButton(driverLeftStick, 5);
        final JoystickButton ekimOn = new JoystickButton(copilot, 3);
        final JoystickButton ekimOn2 = new JoystickButton(driverRightStick, 6);
        final JoystickButton stop = new JoystickButton(driverLeftStick, 1);
        final JoystickButton elevatorUp = new JoystickButton(driverRightStick, 5);
        final JoystickButton elevatorDown = new JoystickButton(driverRightStick, 3);
        final JoystickButton flopperOn = new JoystickButton(driverRightStick, 1);
        final JoystickButton ekimDown = new JoystickButton(copilot, 2);        
        final JoystickButton ekimDown2 = new JoystickButton(driverRightStick, 4);
        final JoystickButton lockerButton = new JoystickButton(copilot, 6);
        final JoystickButton lockerButton2 = new JoystickButton(copilot, 7);

        final JoystickButton ekimCollector = new JoystickButton(copilot, 5);
        final JoystickButton stop2 = new JoystickButton(copilot, 10);

        final JoystickButton activateFineDrive = new JoystickButton(driverRightStick, 2);
        final JoystickButton shootBack = new JoystickButton(driverLeftStick, 8);
        final JoystickButton collectBack = new JoystickButton(driverLeftStick, 3);
        //final JoystickButton shooterBangBang = new JoystickButton(driverRightStick, 1);
        final JoystickButton auto = new JoystickButton(copilot, 11);

        final JoystickButton rad = new JoystickButton(copilot, 9);



        //actions
        shooterOn.toggleWhenPressed(new TurnOnMotor(m_shooter,1));
        collectorOn.toggleWhenPressed(new TurnOnMotor(collectorSubsystem,1));
        ekimOn.whileHeld(new TurnOnMotor(ekimSubsystem,.5));
        ekimOn2.whileHeld(new TurnOnMotor(ekimSubsystem,.8));

        elevatorUp.whileHeld(new TurnOnMotor(elvatorSubsystem,1));
        elevatorDown.whileHeld(new TurnOnMotor(elvatorSubsystem,-1));
        flopperOn.whileHeld(new TurnOnMotor(flopperSubsystem,.5));
        
        ekimDown.whileHeld(new TurnOnMotor(ekimSubsystem,-.5));
        lockerButton.whileHeld(new Climb(elvatorSubsystem,1));
        lockerButton2.whileHeld(new Climb(elvatorSubsystem,-1));
        ekimCollector.whileHeld(new TurnOnMotor(ekimSubsystem,.5).alongWith(new TurnOnMotor(collectorSubsystem,1)));

        ekimDown2.whileHeld(new TurnOnMotor(ekimSubsystem,-.8));
        collectBack.toggleWhenPressed(new TurnOnMotor(collectorSubsystem,-.5));
        shootBack.toggleWhenPressed(new TurnOnMotor(m_shooter,-.5));
        //shooterBangBang.whileHeld(new BangBang(m_shooter,5000));
        activateFineDrive.whileHeld(new FineDrive(m_robotDrive,driverRightStick));
        auto.whenPressed(new SimpleAuto(flopperSubsystem, m_robotDrive, m_shooter, ekimSubsystem));


        //stops
        stop.whenPressed(new StopEverything(ekimSubsystem, flopperSubsystem, elvatorSubsystem,collectorSubsystem, m_shooter ));
        stop2.whenPressed(new StopEverything(ekimSubsystem, flopperSubsystem, elvatorSubsystem,collectorSubsystem, m_shooter ));

        rad.whileHeld(new RadTest(m_robotDrive,driverRightStick));
    }
}
