package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    // public static boolean getLimelightLedsOn() {
    //     return NetworkTableInstance.getDefault().getTable("limelight").getEntry("").getBoolean(true);
    // }

    public static void setLimelightLeds(int value) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(value);
    }

    public static boolean isTargetAvailable() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getBoolean(false);
    }

    public static double getTargetHorizontalAngle() {
        return (double) NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    }

    public static double getDistanceToTarget() {
        double[] camtran = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getDoubleArray(new double[] {0,0,0,0,0,0});
        return (double) Math.sqrt( Math.pow(camtran[0],2) + Math.pow(camtran[2], 2));
    }
}
