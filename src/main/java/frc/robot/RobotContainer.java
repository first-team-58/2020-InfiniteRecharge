package frc.robot;

import java.util.Optional;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * The container for all parts of the robot suich as subsystems, operator interface devices, and commands.
 */
public class RobotContainer {

  /**
   * Initialize a new instance of the RobotContainer class.
   */
  public RobotContainer() {
  }

  /**
   * Initialize the parts of the robot.
   */
  public void initialize() {
    this.configureDashboard();
    this.configureDefaultCommands();
    this.configureButtonBindings();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Optional<Command> getAutonomousCommand() {
    return Optional.empty();
  }

  /**
   * Configure the dashboard.
   */
  private void configureDashboard() {
  }

  /**
   * Configure the default commands for subsystems.
   */
  private void configureDefaultCommands() {
    // TODO
  }

  /**
   * Configures the bindings of buttons to commands.
   */
  private void configureButtonBindings() {
  }
}
