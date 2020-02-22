/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class PIDRotateDriveGyro extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_subsystem;
  private double rotate;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PIDRotateDriveGyro(Drivetrain subsystem, double rotate) {
    m_subsystem = subsystem;
    this.rotate = rotate;
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_subsystem.positionAchieved = false;
      m_subsystem.getNavx().setAngleAdjustment(180.0 - m_subsystem.getNavx().getAngle());
      m_subsystem.rotationSetpoint =  180 + rotate;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
            //double moveValue = RobotContainer.m_driverController.getRawAxis(1);
			//if ((moveValue <= 0.1) && (moveValue >= -0.1)) {
			//	moveValue = 0;
			//}

			RobotContainer.m_drivetrain.pidDriveRotate(0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_subsystem.positionAchieved;
  }
}
