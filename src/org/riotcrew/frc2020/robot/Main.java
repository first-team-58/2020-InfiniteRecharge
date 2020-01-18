package org.riotcrew.frc2020.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Contains the main entry point of the robot application which starts the robot code.
 */
public final class Main {
  private Main() {
  }

  /**
   * Main initialization function.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
