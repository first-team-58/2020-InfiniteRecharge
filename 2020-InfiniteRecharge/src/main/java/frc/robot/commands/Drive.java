/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Drive(Drivetrain subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double moveValue = RobotContainer.m_driverController.getRawAxis(1) *.5;
      double rotateValue = RobotContainer.m_driverController.getRawAxis(4) *.5;

      if(Math.abs(moveValue) < .2) {
          moveValue = 0;
      }

      if(m_subsystem.getSlowSpeed()) {
        moveValue = .5*moveValue;
      }

      if(Math.abs(rotateValue) < .2) {
          rotateValue = 0;
      }

      //rotateValue = rotateValue * ((-.5 * (((m_subsystem.getSpeed()/20000)) * (m_subsystem.getSpeed()/20000))) + 1);
      rotateValue = rotateValue * (((-.5 * ((m_subsystem.getSpeed()/20000))) + 1));

      //-.5x^2 + 1 to reduce steering sensitivity with speed = x
      //SmartDashboard.putNumber("Speed", m_subsystem.getSpeed());
      //SmartDashboard.putBoolean("Slow Speed", m_subsystem.getSlowSpeed());
      //SmartDashboard.putNumber("rotate Modifier", ((-.5 * (((m_subsystem.getSpeed()/20000)) * (m_subsystem.getSpeed()/20000))) + 1));
      //SmartDashboard.putNumber("rotate Modifier", (((-.5 * ((m_subsystem.getSpeed()/20000)))) + 1));
      //System.out.println("Move: " + moveValue + " Rotate: " + rotateValue);
      if(!m_subsystem.pidEnabled) {
        m_subsystem.drive(moveValue, rotateValue);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
