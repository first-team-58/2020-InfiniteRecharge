/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //can addresses
    public static int driveTrainRightFront = 1;
    public static int driveTrainRightRear = 2;
    public static int driveTrainLeftFront = 3;
    public static int driveTrainLeftRear = 4;
    public static int collectorMotor = 5;
    public static int shooterMotor = 6;
    public static int wheelOfFortuneMotor = 7;
    public static int indexerMotor = 8;
    public static int hangerMotor = 9;

    //solenoid ports
    public static int driveTrainSolenoid = 0;
    public static int collectorSolenoid1 = 1;
    public static int collectorSolenoid2 = 2;
    public static int wheelOfFortuneSolenoid1 = 3;
    public static int wheelOfFortuneSolenoid2 = 4;
    public static int hangerSolenoid1 = 5;
    public static int hangerSolenoid2 = 6;

    //Collector Constants
    public static double intakeSpeed = 1.0;
    public static Value intakeUpPosition = Value.kReverse;
    public static Value intakeDownPosition = Value.kForward;

    //Intake Constants
    public static double indexerInSpeed = 1.0;
    public static double indexerOutSpeed = -1.0;
}
