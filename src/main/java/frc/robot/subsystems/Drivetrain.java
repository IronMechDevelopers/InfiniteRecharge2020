/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  // parent motors
  TalonSRX leftFather = new TalonSRX(4);
  TalonSRX rightFather = new TalonSRX(3);
 
  // son motors
  VictorSPX leftSon = new VictorSPX(2);
  VictorSPX rightSon = new VictorSPX(1);


  /**
   * Creates a new Drivetrain.
   */

  public Drivetrain() {
      leftSon.follow(leftFather);
      rightSon.follow(rightFather);

      leftFather.setInverted(true);

      rightFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      rightFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)

      leftFather.configOpenloopRamp(0.5); // 0.5 seconds from neutral to full output (during open-loop control)
      leftFather.configClosedloopRamp(0); // 0 disables ramping (during closed-loop control)

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public Object arcadeDrive(double fwd, double rot) {
  rightFather.set(ControlMode.PercentOutput,fwd+rot);
  leftFather.set(ControlMode.PercentOutput,fwd-rot);
  return null;
}
}
