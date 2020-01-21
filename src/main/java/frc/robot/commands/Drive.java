package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

/**
 * Default command to drive the robot.
 */
public class Drive extends CommandBase {
  private final DriveTrain driveTrain;
  private final DoubleSupplier speed;
  private final DoubleSupplier rotation;

  /**
   * Creates a new Drive command.
   *
   * @param driveTrain The subsystem used by this command.
   * @param speed Provides the desired speed of the drive train.
   * @param rotation Provides the desired roation of the drive train.
   */
  public Drive(DriveTrain driveTrain, DoubleSupplier speed, DoubleSupplier rotation) {
    this.driveTrain = driveTrain;
    this.speed = speed;
    this.rotation = rotation;

    this.addRequirements(driveTrain);
  }

  /**
   * Called repeatedly when this Command is scheduled to run.
   */
  @Override
  public void execute() {
    this.driveTrain.drive(speed.getAsDouble(), rotation.getAsDouble());
  }

  /**
   * Make this return true when this Command no longer needs to run execute()
   */
  @Override
  public boolean isFinished() {
    return false;
  }

  /**
   * Called once after isFinished returns true
   */
  @Override
  public void end(boolean interrupted) {
    this.driveTrain.stop();
  }
}
