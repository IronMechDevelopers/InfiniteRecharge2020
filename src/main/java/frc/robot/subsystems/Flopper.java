/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

public class Flopper extends UnifiedMotorController {
    //flops the flopper and unflops the flopper
    private boolean isIn=true;
    
    public void deploy(double _motorPercentage){
    //inverts position of flopper
    //will be bound to a button as a toggle flopper out/flopper in
        if (isIn){
             isIn=false;
             runBackwards(_motorPercentage);
        }else{
            isIn=true;
             runForward(_motorPercentage);
        }
    }
}

