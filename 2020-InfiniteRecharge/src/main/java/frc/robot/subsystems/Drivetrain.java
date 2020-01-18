/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonSRX leftFrontMotor, rightFrontMotor;
    private WPI_VictorSPX leftRearMotor, rightRearMotor;
    
    private DifferentialDrive drive;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    leftFrontMotor = new WPI_TalonSRX(4);
    rightFrontMotor = new WPI_TalonSRX(2);
    leftRearMotor = new WPI_VictorSPX(5);
    rightRearMotor = new WPI_VictorSPX(3);

    leftFrontMotor.follow(leftRearMotor);
    rightFrontMotor.follow(rightRearMotor);

    drive = new DifferentialDrive(leftRearMotor, rightRearMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double move, double rotate) {
      drive.arcadeDrive(move, rotate);
  }
}
