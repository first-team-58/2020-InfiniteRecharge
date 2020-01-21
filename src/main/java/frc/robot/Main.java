package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Contains the main entry point of the robot program. Changes should not be made to this class.
 */
public final class Main {
  private Main() {
  }

  /**
   * The main initialization function.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
