/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX driveTrainLeftFront, driveTrainRightFront;
    private WPI_TalonFX driveTrainLeftRear, driveTrainRightRear;
    
    private DifferentialDrive drive;

    private boolean slowSpeed = false;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    driveTrainRightFront = new WPI_TalonFX(Constants.driveTrainRightFront);
    driveTrainRightRear = new WPI_TalonFX(Constants.driveTrainRightRear);
    driveTrainLeftFront = new WPI_TalonFX(Constants.driveTrainLeftFront);
    driveTrainLeftRear = new WPI_TalonFX(Constants.driveTrainLeftRear);

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

  public void toggleSlowSpeed() {
    slowSpeed = !slowSpeed;
  }

  public boolean getSlowSpeed() {
    return slowSpeed;
  }

  public double getSpeed() {
    SmartDashboard.putNumber("DTRF", driveTrainRightFront.getSensorCollection().getIntegratedSensorVelocity());
    SmartDashboard.putNumber("DTRR", driveTrainRightRear.getSensorCollection().getIntegratedSensorVelocity());
    SmartDashboard.putNumber("DTLF", driveTrainLeftFront.getSensorCollection().getIntegratedSensorVelocity());
    SmartDashboard.putNumber("DTLR", driveTrainLeftRear.getSensorCollection().getIntegratedSensorVelocity());
    

    double speed = 
    (-1.0 * driveTrainLeftFront.getSensorCollection().getIntegratedSensorVelocity()) + 
    (-1.0 * driveTrainLeftRear.getSensorCollection().getIntegratedSensorVelocity()) + 
    driveTrainRightFront.getSensorCollection().getIntegratedSensorVelocity() +
    driveTrainRightRear.getSensorCollection().getIntegratedSensorVelocity();

    return speed / 4.0 ;
  }
}
