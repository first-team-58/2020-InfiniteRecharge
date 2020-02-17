package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    // public static boolean getLimelightLedsOn() {
    //     return NetworkTableInstance.getDefault().getTable("limelight").getEntry("").getBoolean(true);
    // }

    public static void setLimelightLeds(int value) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(value);
    }
}
