/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.TrapezoidProfileCommand;
import frc.robot.Limelight;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class PIDDistanceDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  Drivetrain m_drivetrain;
  double m_distance;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PIDDistanceDrive(Drivetrain subsystem, double distance) {
    m_drivetrain = subsystem;
    m_distance = distance;
  }

  public void initialize() {
    m_drivetrain.positionAchieved = false;
    m_drivetrain.distanceSetpoint = m_distance;
    m_drivetrain.zeroEncoders();
    m_drivetrain.pidPosCnt = 0;
    m_drivetrain.pidEnabled = true;
  }

  public void execute() {
    RobotContainer.m_drivetrain.pidDrivePosition();
  }

  public boolean isFinished() {
    return m_drivetrain.positionAchieved;
  }
}
