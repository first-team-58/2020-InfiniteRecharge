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
public class ReverseCollector extends CommandBase {
  Collector collector;
  public static int count = 0;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ReverseCollector(Collector subsystem) {
    collector = subsystem;
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
    //if(collector.getSolenoidState().equals(Constants.collectorUpPosition)) {
      if(count < 100) {
        collector.setSolenoidState(Constants.collectorDownPosition);  
      } else {
        collector.setSolenoidState(Constants.collectorOffPosition);
      }

      if(count > 150) {

      } else {
        count++;
      }
    
    collector.setMotor(Constants.collectorOutSpeed);

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
