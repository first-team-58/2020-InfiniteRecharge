package org.riotcrew.frc2020.robot.commands;

import edu.wpi.first.wpilibj.templates.commandbased.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase {
  private final ExampleSubsystem subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem) {
    this.subsystem = subsystem;

    addRequirements(subsystem);
  }

  /**
   * Called when the command is initially scheduled.
   */
  @Override
  public void initialize() {
  }

  /**
   * Called every time the scheduler runs while the command is scheduled.
   */
  @Override
  public void execute() {
  }

  /**
   * Called once the command ends or is interrupted.
   * 
   * @param interrupted true if the command was interrupted.
   */
  @Override
  public void end(boolean interrupted) {
  }

  /**
   * Returns true when the command should end.
   * 
   * @return True if the command is finished.
   */
  @Override
  public boolean isFinished() {
    return false;
  }
}
