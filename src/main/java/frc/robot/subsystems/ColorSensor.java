/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ColorSensor{// extends SubsystemBase {
  // private final I2C.Port i2cPort = I2C.Port.kOnboard;
  // private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  // public int getProx(){
  //   return m_colorSensor.getProximity();
  // }
  // public String getColor(){
  //   Color detectedColor = m_colorSensor.getColor();
  //   m_colorSensor.getProximity();//
  //   SmartDashboard.putNumber("RED",detectedColor.red);
  //   SmartDashboard.putNumber("GREEN",detectedColor.green);
  //   SmartDashboard.putNumber("BLUE",detectedColor.blue);
  //   if (detectedColor.red>=.25 && detectedColor.green >=.4){
  //     return "yellow";
  //   }
  //   else if (detectedColor.blue>=.4){
  //     return "blue";
  //   }else if (detectedColor.red>=.4){
  //     return "red";
  //   }else if (detectedColor.green>=.4){
  //     return "green";
  //   }else {
  //     SmartDashboard.putNumber("RED",m_colorSensor.getColor().red);
  //     SmartDashboard.putNumber("GREEN",m_colorSensor.getColor().green);
  //     SmartDashboard.putNumber("BLUE",m_colorSensor.getColor().blue);
  //     return m_colorSensor.getColor().red+":"+m_colorSensor.getColor().green+":"+m_colorSensor.getColor().blue;
  //   }
  // }
}
