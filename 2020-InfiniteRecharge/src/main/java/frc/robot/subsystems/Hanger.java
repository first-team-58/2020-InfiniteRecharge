/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hanger extends SubsystemBase {
  private DoubleSolenoid solenoid;

  /**
   * Creates a new Collector.
   */
  public Hanger() {
    solenoid = new DoubleSolenoid(Constants.hangerSolenoid1, Constants.hangerSolenoid2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSolenoidState(DoubleSolenoid.Value value) {
      solenoid.set(value);
  }

}
