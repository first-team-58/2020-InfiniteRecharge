/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX rightMotor;
  /**
   * Creates a new Collector.
   */
  public Shooter() {
    leftMotor = new WPI_TalonSRX(Constants.leftShooterMotor);
    rightMotor = new WPI_TalonSRX(Constants.rightShooterMotor);
    //rightMotor.follow(leftMotor);
    rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    leftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    leftMotor.setNeutralMode(NeutralMode.Coast);
    rightMotor.setNeutralMode(NeutralMode.Coast);
    
    leftMotor.setSensorPhase(true);
    rightMotor.setSensorPhase(false);

    leftMotor.configNominalOutputForward(0);
    leftMotor.configNominalOutputReverse(0);
    leftMotor.configPeakOutputForward(1);
    leftMotor.configPeakOutputReverse(-1);
    
    rightMotor.configNominalOutputForward(0);
    rightMotor.configNominalOutputReverse(0);
    rightMotor.configPeakOutputForward(1);
    rightMotor.configPeakOutputReverse(-1);

    leftMotor.config_kF(0, Constants.shooterL_kF);
    leftMotor.config_kP(0, Constants.shooterL_kP);
    leftMotor.config_kI(0, Constants.shooterL_kI);
    leftMotor.config_kD(0, Constants.shooterL_kD);

    rightMotor.config_kF(0, Constants.shooterR_kF);
    rightMotor.config_kP(0, Constants.shooterR_kP);
    rightMotor.config_kI(0, Constants.shooterR_kI);
    rightMotor.config_kD(0, Constants.shooterR_kD);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setLeftMotor(double speed) {
    leftMotor.set(speed);
  }

  public void setLeftMotor(ControlMode mode, double speed) {
    leftMotor.set(mode, speed);
  }

  public void setRightMotor(double speed) {
    rightMotor.set(speed);
  }

  public void setRightMotor(ControlMode mode, double speed) {
    rightMotor.set(mode, speed);
  }

  public double getLeftMotorSpeed() {
    return ((leftMotor.getSelectedSensorVelocity() * 600.0) / 4096.0)/3.0;
  }
  //https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java/VelocityClosedLoop/src/main/java/frc/robot
  public int getLeftMotorSpeedPercent() {
    return (int) (leftMotor.get() * 100);
  }

  public double getRightMotorSpeed() {
    return ((rightMotor.getSelectedSensorVelocity() * 600.0) / 4096.0)/3.0;
  }
  //https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java/VelocityClosedLoop/src/main/java/frc/robot
  public int getRightMotorSpeedPercent() {
    return (int) (rightMotor.get() * 100);
  }

  public double getLeftMotorPIDError() {
    return leftMotor.getClosedLoopError(0);
  }

  public double getRightMotorPIDError() {
    return rightMotor.getClosedLoopError(0);
  }

  public double getRightRawSpeed() {
    return rightMotor.getSelectedSensorVelocity();
  }

  public double getLeftRawSpeed() {
    return leftMotor.getSelectedSensorVelocity();
  }
}
