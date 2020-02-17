/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
    private WPI_TalonSRX motor;
    private DoubleSolenoid solenoid;
    private DigitalInput input;

  /**
   * Creates a new Collector.
   */
  public Collector() {
    motor = new WPI_TalonSRX(Constants.collectorMotor);
    solenoid = new DoubleSolenoid(1, 2);
    input = new DigitalInput(Constants.collectorSensor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed) {
      motor.set(speed);
  }

  public void setSolenoidState(DoubleSolenoid.Value value) {
      solenoid.set(value);
  }

  public DoubleSolenoid.Value getSolenoidState() {
    return solenoid.get();
  }

  public boolean getSensorStateBoolean() {
    return input.get();
  }

  public DigitalInput getSensorState() {
    return input;
  }
}
