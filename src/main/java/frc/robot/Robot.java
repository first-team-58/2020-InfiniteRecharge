package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The framework for connecting the parts within the robot container with the robot lifetime operations and scheduler.
 */
public class Robot extends TimedRobot {
  
  private final CommandScheduler commandScheduler;
  private final RobotContainer robotContainer;

  public Robot() {
    this(CommandScheduler.getInstance(), new RobotContainer());
  }

  public Robot(CommandScheduler commandScheduler, RobotContainer robotContainer) {
    this.commandScheduler = commandScheduler;
    this.robotContainer = robotContainer;
  }

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    this.robotContainer.initialize();
  }

  /**
   * This function is called for every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   */
  @Override
  public void robotPeriodic() {
    this.commandScheduler.run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically while the robot is in Disabled mode.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    this.robotContainer.getAutonomousCommand().ifPresent(Command::schedule);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    this.robotContainer.getAutonomousCommand().ifPresent(Command::cancel);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * Cancels all running commands when the test mode is initialized.
   */
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
