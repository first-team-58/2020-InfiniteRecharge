/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Collector;
import frc.robot.commands.CollectorIn;
import frc.robot.commands.CollectorDown;

/**
 * An example command that uses an example subsystem.
 */
public class CollectorDeploy extends ParallelCommandGroup {
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public CollectorDeploy(Collector subsystem) {
    addCommands(new CollectorIn(subsystem), new CollectorDown(subsystem));
  }
}
