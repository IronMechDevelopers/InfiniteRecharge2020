/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*a sort of master class for the function of running motors in two directions, the ID of the motor is specified when calling the
*methods in the command.*/

public class UnifiedMotorController extends SubsystemBase {
    protected double motorPercentage;
    protected Victor motor;

    public void setConstant(int c){
        this.motor = new Victor(c);
    }
    //runs the motor in a "forwards" direction
    public void runForward(double _motorPercentage) {
        motorPercentage = 0.0;
        this.motorPercentage=_motorPercentage;
        motor.set(motorPercentage);
        
    }
    //runs the motor in a "backwards" direction
    public void runBackwards(double _motorPercentage) {
        motorPercentage = 0.0;
        this.motorPercentage=_motorPercentage * -1;
        motor.set(motorPercentage);

    }

    public void stopMotor()
    {
        motor.set(0);
    }
}