/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class Shooter extends SubsystemBase {

    private Victor shooter = new Victor(ShooterConstants.shooterMotor);
    private double motorPercentage;
    //feeds balls into shooter
    public void feedToShooter() {
        motorPercentage=0.0;
    }

    public void increaseSpeed(double increaseSpeed)
    {
        motorPercentage+=Math.abs(increaseSpeed);
    }
    public void decreaseSpeed(double decreaseSpeed)
    {
        motorPercentage-=Math.abs(decreaseSpeed);
    }

    //shoots the balls
    public void shoot(double _motorPercentage) {
        this.motorPercentage=_motorPercentage;
        shooter.set(motorPercentage);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
        log();
    }

    public void log() {
        SmartDashboard.putNumber("Shooting Speed", ShooterConstants.shooterSpeed);
    }
}
