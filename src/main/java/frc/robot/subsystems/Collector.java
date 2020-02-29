/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants.DriveConstants.FlopperConstants;

/**
 * Add your docs here.
 */
public class Collector extends UnifiedMotorController {

    private Victor collectMotor = new Victor(FlopperConstants.collectMotor);

	public void collect() {
        collectMotor.set(.75);
	}

	public void stopCollect() {
        collectMotor.set(0);
    }
    
}
