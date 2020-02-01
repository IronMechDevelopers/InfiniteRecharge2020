/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants.FlopperConstants;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**
 * Add your docs here.
 */
public class Flopper extends SubsystemBase {
    //flops the flopper and unflops the flopper
    private boolean isIn=true;
    private double motorPercentage;
    private Victor flopper = new Victor(FlopperConstants.flopperMotor);
    
    public void move(double _motorPercentage){
    //inverts position of flopper
    //will be bound to a button as a toggle flopper out/flopper in
        if (isIn){
             isIn=false;
             //TODO adk mr Rad1 how to make motors go in reverse .
             this.motorPercentage=_motorPercentage*-1;
             flopper.set(motorPercentage);
        }else{
            isIn=true;
            //TODO ask mr Rad1 how to make motors go .
            this.motorPercentage=_motorPercentage;
            flopper.set(motorPercentage);
        }
    }
}

