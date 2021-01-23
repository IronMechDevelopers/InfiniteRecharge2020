/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;



public class Drivetrain extends SubsystemBase {

//ticks per inche
private double ticksPerRev=1024;
private double wheelDiameterInches=7.87402;
private double wheelCircumfranceInches=wheelDiameterInches*Math.PI;
private double ticksPerInch=ticksPerRev/wheelCircumfranceInches;

private final SpeedController m_leftMotor;
private final SpeedController m_rightMotor;

private final DifferentialDrive m_drive;


  // parent motors
  private WPI_TalonSRX leftFather = new WPI_TalonSRX(DriveConstants.LEFTFATHER);
  private WPI_TalonSRX rightFather = new WPI_TalonSRX(DriveConstants.RIGHTFATHER);
 
  // son motors
  private WPI_VictorSPX leftSon = new WPI_VictorSPX(DriveConstants.LEFTSON);
  private WPI_VictorSPX rightSon = new WPI_VictorSPX(DriveConstants.RIGHTSON);

  //IMU
  private ADIS16448_IMU m_gyro = new ADIS16448_IMU ();

  private NeutralMode brakeMode = NeutralMode.Brake;

  private int leftOffset=0;
  private int rightOffset=0;






  /**
   * Creates a new Drivetrain.
   */

  public Drivetrain() {

    super();

    leftFather.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightFather.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);


    rightFather.setNeutralMode(brakeMode);
    leftFather.setNeutralMode(brakeMode);
    rightSon.setNeutralMode(brakeMode);
    leftSon.setNeutralMode(brakeMode);
    leftFather.setSensorPhase(true);
    rightFather.setSensorPhase(true);
    leftFather.setInverted(true); 
    rightFather.setInverted(true);
    
    
      leftSon.follow(leftFather);
      rightSon.follow(rightFather);
      //leftSon.setInverted(InvertType.FollowMaster); // match whatever leftFather is
      //rightSon.setInverted(InvertType.FollowMaster
      //leftSon.setInverted(InvertType.FollowMaster); // match whatever rightFather is
      //rightSon.setInverted(InvertType.OpposeMaster); // opposite whatever rightFather is

    setTalon(leftFather);
    setTalon(rightFather);

      

      rightFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      rightFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)

      leftFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      leftFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)


          // Let's name the sensors on the LiveWindow

          m_leftMotor = new SpeedControllerGroup(leftFather, leftSon);
          m_rightMotor = new SpeedControllerGroup(rightFather, rightSon);
          m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    addChild("Drive", m_drive);
    addChild("Gyro", m_gyro);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      log();
  }

    /**
   * The log method puts interesting information to the SmartDashboard.
   */
  public void log() {
    SmartDashboard.putNumber("XAxis", m_gyro.getGyroAngleX());
    SmartDashboard.putNumber("YAxis", m_gyro.getGyroAngleY());
    SmartDashboard.putNumber("ZAxis", m_gyro.getGyroAngleZ());

    SmartDashboard.putNumber("rightVelocity",rightFather.getSelectedSensorVelocity());
    SmartDashboard.putNumber("leftVelocity",leftFather.getSelectedSensorVelocity());

    SmartDashboard.putNumber("Velocity",(rightFather.getSelectedSensorVelocity()+leftFather.getSelectedSensorVelocity())/2.0);

    SmartDashboard.putNumber("Distance:", rightFather.getSelectedSensorPosition());



  }

    /**
   * Tank style driving for the DriveTrain.
   *
   * @param left  Speed in range [-1,1]
   * @param right Speed in range [-1,1]
   */
  public void drive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void rad(double num)
  {
    leftFather.set(ControlMode.Velocity, num);
    rightFather.set(ControlMode.Velocity, num);
  }
  
public Object arcadeDrive(double fwd, double rot) {
  // rightFather.set(ControlMode.PercentOutput,fwd+rot);
  // leftFather.set(ControlMode.PercentOutput,fwd-rot);
  m_drive.arcadeDrive(fwd, -1*rot);
  // m_drive.tankDrive(left, right);
  return null;
}

  /**
   * Reset the robots sensors to the zero states.
   */
  public void reset() {
    m_gyro.reset();
    // leftOffset = leftFather.getSelectedSensorPosition();
    // rightOffset = rightFather.getSelectedSensorPosition();
  }
  public int getLeftTicks() {
    return 0;
    // return leftFather.getSelectedSensorPosition() - leftOffset;
  }
  public int getRightTicks() {
    return 0;
    // return rightFather.getSelectedSensorPosition() - rightOffset;

  }
    /**
   * Get the average distance of the encoders since the last reset.
   *
   * @return The distance driven (average of left and right encoders).
   */
  public double getAverageTicks() {
    return (getLeftTicks()+getRightTicks())/(2.0);
  }
  public double getRightDistance(){
    return getRightTicks()/ticksPerInch;//returns distance in inches
  }
  public double getLeftDistance(){
    return getLeftTicks()/ticksPerInch;//returns distance in inches
  }
  public double getAverageDistance() {
    return (getLeftDistance()+getRightDistance())/(2.0);
  }

  public void setTalon(WPI_TalonSRX _talon)
  {

		/* Set relevant frame periods to be at least as fast as periodic rate */
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		/* Set the peak and nominal outputs */
		_talon.configNominalOutputForward(0, Constants.kTimeoutMs);
		_talon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		_talon.configPeakOutputForward(1, Constants.kTimeoutMs);
		_talon.configPeakOutputReverse(-1, Constants.kTimeoutMs);



		/* Set Motion Magic gains in slot0 - see documentation */
		_talon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		_talon.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		_talon.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		_talon.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		_talon.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);

		/* Set acceleration and vcruise velocity - see documentation */
		_talon.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		_talon.configMotionAcceleration(6000, Constants.kTimeoutMs);

		/* Zero the sensor once on robot boot up */
		_talon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
  }

}
