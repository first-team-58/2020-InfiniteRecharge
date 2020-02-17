/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Indexer;
/**
 * An example command that uses an example subsystem.
 */
public class StopCollecting extends CommandBase {
  Collector collector;
  Indexer indexer;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public StopCollecting(Collector subsystem, Indexer subsystem2) {
    collector = subsystem;
    indexer = subsystem2;
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
      collector.setMotor(0);
      indexer.setMotor(0);
      collector.setSolenoidState(Constants.collectorUpPosition);
      CollectorBallToShooter.count = 0;
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
