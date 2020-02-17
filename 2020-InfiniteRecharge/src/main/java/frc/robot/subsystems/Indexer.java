/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  private WPI_TalonSRX motor;
  private WPI_TalonSRX motor2;
  private DigitalInput indexerLast;
  private DigitalInput indexerFirst;

  /**
   * Creates a new Indexer.
   */
  public Indexer() {
    motor = new WPI_TalonSRX(Constants.indexerMotor);
    motor2 = new WPI_TalonSRX(Constants.topIndexer);
    indexerLast = new DigitalInput(Constants.indexerTopSensor);
    indexerFirst = new DigitalInput(Constants.indexerBottomSensor);
    //motor2.follow(motor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed) {
      motor.set(speed);
      motor2.set(speed);
  }

  public void setTopMotor(double speed) {
    motor2.set(speed);
  }

  public void setBottomMotor(double speed) {
    motor.set(speed);
  }

  public boolean getIndexerTopBool() {
    return indexerLast.get();
  }

  public DigitalInput getIndexerTop() {
    return indexerLast;
  }

  public boolean getIndexerBottomBool() {
    return indexerFirst.get();
  }

  public DigitalInput getIndexerBottom() {
    return indexerFirst;
  }
}
