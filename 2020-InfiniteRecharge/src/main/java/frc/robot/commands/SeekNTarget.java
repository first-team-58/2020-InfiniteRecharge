package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelight {

    public void limelight (){
    
    }

    public void initialize (){

    }
     public double getXValue(){
        return Limelight.getTargetHorizontalAngle();
     }
     public double getYValue(){
         return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
     }

    public void strait (double XValue){
        if (XValue > 0.2 /*its to the right*/ ) {
            
        } else if (XValue < -0.2 /* its to the left*/){

        }
    }



}


