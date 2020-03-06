/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Hanger extends SubsystemBase {
  private final Solenoid brake;
  private final Solenoid arm;
  private final WPI_TalonSRX motor;

  /**
   * Creates a new Collector.
   */
  public Hanger() {
    brake = new Solenoid(Constants.hangerBrake);
    arm = new Solenoid(Constants.hangerSolenoid1);
    motor = new WPI_TalonSRX(Constants.hangerMotor);
    // Another feeble attempt. This time to add encoder for hanger functions
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setBrakeState(final boolean state) {
    brake.set(state);
  }

  public void setArmState(final boolean state) {
    arm.set(state);
  }

  public void setMotor(final double speed) {
    motor.set(speed);// (speed)
  }

  public double getHangerVelocity() {
    return ((motor.getSelectedSensorVelocity()));
  }

  public double getHangerPosition() {
    return ((motor.getSelectedSensorPosition()));
  }

}
