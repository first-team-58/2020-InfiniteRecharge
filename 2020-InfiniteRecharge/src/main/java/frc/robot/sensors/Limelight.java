package frc.robot.sensors;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight {

    private NetworkTable m_limelight;
    private NetworkTableEntry tv, tx, ty, ta;
    private double m_mountingAngleDegrees, m_lenseHeightInches;
    private double m_moveValue, m_rotateValue;
    private double prev_tx = 1.0;
    private double kpAim = 0.05;
    private double kpDistance = 0.05;
 

    public Limelight (String limelightName, double mountingAngleDegrees, double lenseHeightInches) {
        m_limelight = NetworkTableInstance.getDefault().getTable(limelightName);
        m_mountingAngleDegrees = mountingAngleDegrees;
        m_lenseHeightInches = lenseHeightInches;
        //m_isRedAlliance = NetworkTableInstance.getDefault().getTable("FRC").getEntry("frc").
    }

    public void setLight(boolean state) {
        m_limelight.getEntry("ledMode").setNumber(state ? 3.0 : 1.0); 
    }

    public boolean isTargetAvailable() {
        return (m_limelight.getEntry("tv").getDouble(0) == 1);
    }

    public double getTargetHorizontalAngle() {
        return m_limelight.getEntry("tx").getDouble(0);
    }

    public double getTargetVerticalAngle() {
        return m_limelight.getEntry("ty").getDouble(0);
    }

    public double getDistanceToTarget(double targetHeightInches) {

        double targetOffsetAngle_Vertical = ty.getDouble(0.0);

        double angleToTargetDegrees = m_mountingAngleDegrees + targetOffsetAngle_Vertical;
        double angleToTargetRadians = angleToTargetDegrees * (3.14159 / 180.0);

        //calculate distance
        double distance = (targetHeightInches - m_lenseHeightInches)/Math.tan(angleToTargetRadians);
        SmartDashboard.putNumber("Distance to Target", distance);
        return distance;
    }

    public void setLimelightPipeline(int value) {
        m_limelight.getEntry("pipeline").setNumber(value);
    }

    public void updateLimelightValues() {
        
        tv = getEntry("Found Vision Target", "tv");
        tx = getEntry("Crosshair Horizontal Offset", "tx");
        ty = getEntry("Crosshair Vertical Offset", "ty");
        ta = getEntry("Target Area", "ta");

        SmartDashboard.putNumber("tv", tv.getDouble(0));
        SmartDashboard.putNumber("tx", tx.getDouble(0));
        SmartDashboard.putNumber("ty", ty.getDouble(0));
        SmartDashboard.putNumber("ta", ta.getDouble(0));
    }

    private double getCorrection(double input) {
        double correctionMin = 0.003;
        double deadZone = 0.05;
        double correction = input * kpAim;

        if (correction < correctionMin) correction = Math.copySign(correctionMin, correction);
        if (Math.abs(input) < deadZone) correction = 0;
        return correction;
    }

    private double getLimelightX() {
        updateLimelightValues();
       // return getCorrection(tx.getDouble(0));
       return tx.getDouble(0);
    }

    private double getLimelightY() {
        updateLimelightValues();
        return getCorrection(tx.getDouble(0));
    }

    public double aimToTarget() {
        return getLimelightX();
    }

    public double[] newDriveToTarget() {
        double[] retVal = new double[2];
        retVal[0] = getLimelightX();
        retVal[1] = getLimelightY();

        return retVal;
    }

    public double[] driveToTarget() {

        double[] retVal= new double[2];
        
        if(isTargetAvailable()){
            m_moveValue = ty.getDouble(0) * kpDistance;
            m_rotateValue = tx.getDouble(0) * kpAim;
          }else{
            m_moveValue = 0;
            m_rotateValue = 0;
          }

          retVal[0] = m_moveValue;
          retVal[1] = m_rotateValue;
          
        return retVal;
    }

    public double seekTarget() {
        return 0;
    }

    private NetworkTableEntry getEntry(String dashboardName, String tableEntry) {
        if (tableEntry == "tx") {
            prev_tx = tx.getDouble(0);
            SmartDashboard.putNumber("Prev_tx", prev_tx);
        }
        NetworkTableEntry value = m_limelight.getEntry(tableEntry);
        SmartDashboard.putNumber(dashboardName, value.getDouble(0));

        return value;
    }
}