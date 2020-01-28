/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {
        public static final int RIGHTSON = 0;
        public static final int LEFTSON = 1;
        public static final int RIGHTFATHER = 2;
        public static final int LEFTFATHER = 3;
    
        public static final boolean kLeftEncoderReversed = false;
        public static final boolean kRightEncoderReversed = true;
    
        public static final int kEncoderCPR = 4096;
        public static final double kWheelDiameterInches = 7.5;

        public static final double INCHESPERPULSE = (1.0)/((kEncoderCPR/1.0) * (1.0/kWheelDiameterInches));
        public static final double kEncoderDistancePerPulse =
            // Assumes the encoders are directly mounted on the wheel shafts
            (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;

        public static double kMaxRPM = 5330;
        public static double kSensorUnitsPerRotation = kEncoderCPR;
        public static double kGearRatio=10.71;

        public static double magicNumber =  (kMaxRPM  / 600) * (kSensorUnitsPerRotation / kGearRatio);
      }

 public static final class ShooterConstants {

  public static final int shooterMotor =0;
 }

      public static final class AutoConstants {
        public static final double INCH = 1;
        public static final double FEET = 12;
        public static final double YARD = FEET*3;
        public static final double SECON = 1;
      }

      

}
