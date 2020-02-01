/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants.CollecterConstants;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collecter extends SubsystemBase{
    //activates collector to suck in and dispense balls
    private double motorPercentage;
    private Victor collecter =new Victor (CollecterConstants.collecterMotor);
    
    public void collect(double _motorPercentage){
        //runs the collector motor forwards so the colleter can intake balls
        motorPercentage = 0.0;
        this.motorPercentage=_motorPercentage;
        collecter.set(motorPercentage);
    }
}