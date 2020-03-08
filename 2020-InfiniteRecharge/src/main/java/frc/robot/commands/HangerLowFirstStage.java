/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hanger;
/**
 * An example command that uses an example subsystem.
 */
public class HangerLowFirstStage extends CommandBase {
    Hanger m_subsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HangerLowFirstStage(final Hanger subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    // addRequirements(subsystem);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.setMotor(Constants.hangerDownSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_subsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
     
    if (m_subsystem.getMotorControllerTalonSRX().getSelectedSensorPosition() > Constants.hangerRetractStart) { //motor.getSelectedSensorPosition
    		return false; // 
    	} else {
        //m_subsystem.getMotorControllerTalonSRX().setSelectedSensorPosition(0);
        return true;//
    	}

    //return true;
  }
}
