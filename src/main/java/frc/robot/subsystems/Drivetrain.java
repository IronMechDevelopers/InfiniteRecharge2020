/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;



public class Drivetrain extends SubsystemBase {

//ticks per inche
private double ticksPerRev=1024;
private double wheelDiameterInches=7.87402;
private double wheelCircumfranceInches=wheelDiameterInches*Math.PI;
private double ticksPerInch=ticksPerRev/wheelCircumfranceInches;



  // parent motors
  private TalonSRX leftFather = new TalonSRX(DriveConstants.LEFTFATHER);
  private TalonSRX rightFather = new TalonSRX(DriveConstants.RIGHTFATHER);
 
  // son motors
  private VictorSPX leftSon = new VictorSPX(DriveConstants.LEFTSON);
  private VictorSPX rightSon = new VictorSPX(DriveConstants.RIGHTSON);

  //IMU
  private ADIS16448_IMU imu = new ADIS16448_IMU ();

  private NeutralMode brakeMode = NeutralMode.Brake;

  private int leftOffset=0;
  private int rightOffset=0;




  /**
   * Creates a new Drivetrain.
   */

  public Drivetrain() {

    leftFather.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightFather.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    rightFather.setNeutralMode(brakeMode);
    leftFather.setNeutralMode(brakeMode);
    rightSon.setNeutralMode(brakeMode);
    leftSon.setNeutralMode(brakeMode);
    leftFather.setSensorPhase(true);
    rightFather.setSensorPhase(true);
    leftFather.setInverted(true);
    rightFather.setInverted(false);
    
    
      leftSon.follow(leftFather);
      rightSon.follow(rightFather);
      // leftSon.setInverted(InvertType.FollowMaster); // match whatever leftFather is
      leftSon.setInverted(false);
      rightSon.setInverted(InvertType.FollowMaster); // match whatever rightFather is
      //rightSon.setInverted(InvertType.OpposeMaster); // opposite whatever rightFather is


      

      rightFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      rightFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)

      leftFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      leftFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)

    
  }


  public void testDrive(){
    //a test drive function to see if we have the correct code in commands
    ControlMode controlMode=ControlMode.PercentOutput;
    leftFather.set(controlMode,0.1);
    rightFather.set(controlMode,0.1);
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
    // SmartDashboard.putNumber("XAxis", imu.getGyroAngleX());
    // SmartDashboard.putNumber("YAxis", imu.getGyroAngleY());
    // SmartDashboard.putNumber("ZAxis", imu.getGyroAngleZ());
    // SmartDashboard.putNumber("rightVelocity",rightFather.getSelectedSensorVelocity());
    // SmartDashboard.putNumber("leftVelocity",leftFather.getSelectedSensorVelocity());

    // SmartDashboard.putNumber("rightPosition",getRightDistance());
    // SmartDashboard.putNumber("leftPosition" ,getLeftDistance());

    // SmartDashboard.putNumber("Out % left", leftFather.getMotorOutputPercent());
    // SmartDashboard.putNumber("Out % right", rightFather.getMotorOutputPercent());

    // SmartDashboard.putNumber("testing", rightFather.getMotorOutputPercent());

    // SmartDashboard.putNumber("INCHESPERPULSE", DriveConstants.INCHESPERPULSE);
    // SmartDashboard.putNumber("kEncoderDistancePerPulse", DriveConstants.kEncoderDistancePerPulse);
    // SmartDashboard.putNumber("magicNumber", DriveConstants.magicNumber);

  }

  
public Object arcadeDrive(double fwd, double rot) {
  rightFather.set(ControlMode.PercentOutput,fwd+rot);
  leftFather.set(ControlMode.PercentOutput,fwd-rot);
  return null;
}

  /**
   * Reset the robots sensors to the zero states.
   */
  public void reset() {
    imu.reset();
    leftOffset = leftFather.getSelectedSensorPosition();
    rightOffset = rightFather.getSelectedSensorPosition();
  }
  public int getLeftTicks() {
    return leftFather.getSelectedSensorPosition() - leftOffset;
  }
  public int getRightTicks() {
    return rightFather.getSelectedSensorPosition() - rightOffset;

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

}
