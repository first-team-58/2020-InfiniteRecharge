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
    public static int leftShooterMotor = 6;
    public static int wheelOfFortuneMotor = 7;
    public static int indexerMotor = 8;
    public static int hangerMotor = 9;
    public static int topIndexer = 10;
    public static int rightShooterMotor = 11;

    //solenoid ports
    public static int driveTrainSolenoid = 0;
    public static int collectorSolenoid1 = 1;
    public static int collectorSolenoid2 = 2;
    public static int wheelOfFortuneSolenoid1 = 5;
    //public static int wheelOfFortuneSolenoid2 = 4;
    public static int hangerSolenoid1 = 3;
    public static int hangerSolenoid2 = 4;
    public static int hangerBreak = 6;

    //DIO PORTS
    public static int collectorSensor = 0;
    public static int indexerBottomSensor = 1;
    public static int indexerTopSensor = 2;

    //Collector Constants
    public static double collectorInSpeed = 0.4;
    public static double collectorOutSpeed = -1.0;
    public static Value collectorUpPosition = Value.kOff;
    public static Value collectorDownPosition = Value.kReverse;
    public static Value collectorOffPosition = Value.kForward;

    //collector Constants
    public static double indexerInSpeed = -0.3 ;
    public static double indexerOutSpeed = 0.3;

    //Hanger Constants
    public static double hangerUpSpeed = 1.0;
    public static double hangerDownSpeed = -1.0;
    public static Value hangerReleaseState = Value.kForward;

    //WheelOfFortune Constants
    public static double wOFCCW = 1.0;
    public static double wOFCW = -1.0;
    public static Value wOFDeployedState = Value.kForward;
    public static Value wOFRetractedState = Value.kReverse;

    //shooter Constants
    public static double shooterL_kF = 1.0*(1023.0/120000.0); //.27
    public static double shooterL_kP = 0.004;
    public static double shooterL_kI = 0.001;
    public static double shooterL_kD = 0;//2;

    public static double shooterR_kF = 1.04*(1023.0/120000.0);//1023.0/7200.0; //1023.0 / 7200.0;
    public static double shooterR_kP = 0.004; //.025;
    public static double shooterR_kI = 0.001; //.0001;
    public static double shooterR_kD = 0;//2; //2;
    
    public static double shooter_speedTarget = 1; //needs to be set in units / 100ms, so 500 rpm would be 500.0 * 4960 (encoder ticks per revolution) / 600

    //drive Constants
    public static boolean driveSolenoidSlow = true;
}
