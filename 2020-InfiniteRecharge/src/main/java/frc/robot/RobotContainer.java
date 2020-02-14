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
  public static final Drivetrain m_drivetrain = new Drivetrain();

  public static final Collector m_collector = new Collector();

  public static final Hanger m_hanger = new Hanger();

  public static final Indexer m_indexer = new Indexer();

  public static final Shooter m_shooter = new Shooter();

  public static final WheelOfFortune m_wheelOfFortune = new WheelOfFortune();

  // Robots commands are defined here
  public final Drive m_drive = new Drive(m_drivetrain);

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
    m_driverAButton.whenPressed(new CollectorDeploy(m_collector));
    m_driverAButton.whenReleased(new CollectorRetract(m_collector));
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
