package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Subsystem;


public class SeekNTarget extends CommandBase {
    private Drivetrain m_subsytem;

    public SeekNTarget (Drivetrain subsystem){
        m_subsytem = subsystem;
    }

   
     public double getXValue(){
        return Limelight.getTargetHorizontalAngle();
     }
     public double getYValue(){
         return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
     }

    public void strait (double XValue){
        if (XValue > 0.2 /*its to the right*/ ) {
            m_subsytem.drive(0,XValue);
        } else if (XValue < -0.2 /* its to the left*/){
            m_subsytem.drive(0,XValue);
        }
    }



}


