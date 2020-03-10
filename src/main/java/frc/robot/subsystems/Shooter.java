/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants.ShooterConstants;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.lang3.ArrayUtils;
/** 
 * Add your docs here.
 */
public class Shooter extends UnifiedMotorController {

    private double motorPercentage;
    private Encoder encoder;
    private CircularFifoQueue<Double> queue = new CircularFifoQueue<>(ShooterConstants.movingAverage);
    //feeds balls into shooter
    public Shooter()
    {
        super();
        super.setConstant(ShooterConstants.shooterMotor);
        super.motor.setInverted(true);
        encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        encoder.setDistancePerPulse(2048);

        // Configures the encoder to consider itself stopped after .1 seconds
        encoder.setMaxPeriod(.1);

        // Configures the encoder to consider itself stopped when its rate is below 10
        encoder.setMinRate(10);

        // Reverses the direction of the encoder
        encoder.setReverseDirection(true);

        // Configures an encoder to average its period measurement over 5 samples
        // Can be between 1 and 127 samples
        encoder.setSamplesToAverage(5);
    }
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

    public double getEncoderRate()
    {
        return encoder.getRate();
    }


    public void log() {
        // SmartDashboard.putNumber("Shooting Speed", ShooterConstants.shooterSpeed);
        // queue.add(Math.min(10000,encoder.getRate()));
        // double[] values = ArrayUtils.toPrimitive(queue.toArray(new Double[0]));
        // double num = StatUtils.mean(values, 0, (ShooterConstants.movingAverage));
        // SmartDashboard.putNumber("Encoder speed in inches",num);
        SmartDashboard.putNumber("Encoder speed in inches",encoder.getRate());
    }

}
