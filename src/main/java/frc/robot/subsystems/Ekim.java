/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants.DriveConstants.EkimConstants;

/**
 * Add your docs here.
 */
public class Ekim extends UnifiedMotorController {
    private Victor ekimMotor;
    
    public Ekim(){
        super();
        setConstant(EkimConstants.ekimMotor);
    }

    public void ekim(){
        ekimMotor.set(.5);
    }
    public void stopEkim(){
        ekimMotor.set(0);
    }

}
