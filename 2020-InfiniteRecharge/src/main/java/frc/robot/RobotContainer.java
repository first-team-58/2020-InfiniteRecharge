/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Robots subsystems are defined here
  private final Drivetrain m_drivetrain = new Drivetrain();

  private final Collector m_collector = new Collector();

  private final Hanger m_hanger = new Hanger();

  private final Indexer m_indexer = new Indexer();

  private final Shooter m_shooter = new Shooter();

  private final WheelOfFortune m_wheelOfFortune = new WheelOfFortune();

  // Robots commands are defined here
  private final Drive m_drive = new Drive(m_drivetrain);

// Controller stuff
  public static final XboxController m_driverController = new XboxController(0);

  private static final JoystickButton m_driverAButton = new JoystickButton(m_driverController, 1);
  private static final JoystickButton m_driverBButton = new JoystickButton(m_driverController, 2);
  private static final JoystickButton m_driverXButton = new JoystickButton(m_driverController, 3);
  private static final JoystickButton m_driverYButton = new JoystickButton(m_driverController, 4);
  private static final JoystickButton m_driverLSButton = new JoystickButton(m_driverController, 9);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_driverAButton.whenPressed(new ToggleCollectorPosition(m_collector));
    m_driverLSButton.whenPressed(new ToggleSlowSpeed(m_drivetrain));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return null;
  }

  public Command getDriveCommand() {
    return m_drive;
  }
}
