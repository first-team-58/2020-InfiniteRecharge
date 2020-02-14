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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX motor;
  /**
   * Creates a new Collector.
   */
  public Shooter() {
    motor = new WPI_TalonSRX(Constants.shooterMotor);
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    motor.setSensorPhase(true);
    motor.configNominalOutputForward(0);
    motor.configNominalOutputReverse(0);
    motor.configPeakOutputForward(1);
    motor.configPeakOutputReverse(-1);

    motor.config_kF(0, Constants.shooter_kF);
    motor.config_kP(0, Constants.shooter_kP);
    motor.config_kI(0, Constants.shooter_kI);
    motor.config_kD(0, Constants.shooter_kD);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed) {
    motor.set(speed);
  }

  public void setMotor(ControlMode mode, double speed) {
    motor.set(mode, speed);
  }

  public double getMotorSpeed() {
    return motor.getSelectedSensorVelocity();
  }
  //https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java/VelocityClosedLoop/src/main/java/frc/robot
  public int getMotorSpeedPercent() {
    return (int) (motor.get() * 100);
  }
}
