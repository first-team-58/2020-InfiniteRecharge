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

public class Hanger extends SubsystemBase {
  private Solenoid brake;
  private Solenoid arm;
  private WPI_TalonSRX motor;

  /**
   * Creates a new Collector.
   */
  public Hanger() {
    brake = new Solenoid(Constants.hangerBrake);
    arm = new Solenoid(Constants.hangerSolenoid1);
    motor = new WPI_TalonSRX(Constants.hangerMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setBrakeState(boolean state) {
      brake.set(state);
  }

  public void setArmState(boolean state) {
    arm.set(state);
  }

  public void setMotor(double speed) {
    motor.set(speed);// (speed)
  }

}
