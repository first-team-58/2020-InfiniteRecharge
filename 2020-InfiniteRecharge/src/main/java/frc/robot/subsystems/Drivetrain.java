/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX driveTrainLeftFront, driveTrainRightFront;
    private WPI_TalonFX driveTrainLeftRear, driveTrainRightRear;
    
    private DifferentialDrive drive;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    driveTrainRightFront = new WPI_TalonFX(1);
    driveTrainRightRear = new WPI_TalonFX(2);
    driveTrainLeftFront = new WPI_TalonFX(3);
    driveTrainLeftRear = new WPI_TalonFX(4);
    

    driveTrainLeftFront.follow(driveTrainLeftRear);
    driveTrainRightFront.follow(driveTrainRightRear);

    drive = new DifferentialDrive(driveTrainLeftRear, driveTrainRightRear);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double move, double rotate) {
      drive.arcadeDrive(move, rotate);
  }
}
