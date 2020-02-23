/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
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

  //public final ParallelRaceGroup m_autocmd = new DriveForwardAuto(m_drivetrain).withTimeout(3);
// Controller stuff
  public static final XboxController m_driverController = new XboxController(0);
  public static final XboxController m_operatorController = new XboxController(1);

  private static final JoystickButton m_driverAButton = new JoystickButton(m_driverController, 1);
  private static final JoystickButton m_driverBButton = new JoystickButton(m_driverController, 2);
  private static final JoystickButton m_driverXButton = new JoystickButton(m_driverController, 3);
  private static final JoystickButton m_driverYButton = new JoystickButton(m_driverController, 4);
  private static final JoystickButton m_driverLBButton = new JoystickButton(m_driverController, 5);
  private static final JoystickButton m_driverRBButton = new JoystickButton(m_driverController, 6);
  private static final JoystickButton m_driverSeButton = new JoystickButton(m_driverController, 7);
  private static final JoystickButton m_driverStButton = new JoystickButton(m_driverController, 8);
  private static final JoystickButton m_driverLSButton = new JoystickButton(m_driverController, 9);
  private static final JoystickButton m_driverRSButton = new JoystickButton(m_driverController, 10);
  private static final JoystickAnalogButton m_driverRTrButton = new JoystickAnalogButton(m_driverController, 3, JoystickAnalogButton.direction.UP);
  private static final JoystickAnalogButton m_driverLTrButton = new JoystickAnalogButton(m_driverController, 2, JoystickAnalogButton.direction.UP);

  private static final JoystickButton m_operatorAButton = new JoystickButton(m_operatorController, 1);
  private static final JoystickButton m_operatorBButton = new JoystickButton(m_operatorController, 2);
  private static final JoystickButton m_operatorXButton = new JoystickButton(m_operatorController, 3);
  private static final JoystickButton m_operatorYButton = new JoystickButton(m_operatorController, 4);
  private static final JoystickButton m_operatorLBButton = new JoystickButton(m_operatorController, 5);
  private static final JoystickButton m_operatorRBButton = new JoystickButton(m_operatorController, 6);
  private static final JoystickButton m_operatorSeButton = new JoystickButton(m_operatorController, 7);
  private static final JoystickButton m_operatorStButton = new JoystickButton(m_operatorController, 8);
  private static final JoystickButton m_operatorLSButton = new JoystickButton(m_operatorController, 9);
  private static final JoystickButton m_operatorRSButton = new JoystickButton(m_operatorController, 10);
  private static final JoystickAnalogButton m_operatorRTrButton = new JoystickAnalogButton(m_operatorController, 3, JoystickAnalogButton.direction.UP);
  private static final JoystickAnalogButton m_operatorLTrButton = new JoystickAnalogButton(m_operatorController, 2, JoystickAnalogButton.direction.UP);

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
    //m_driverAButton.whenPressed(new CollectorDeploy(m_collector));
    //m_driverAButton.whileActiveOnce(new CollectorDeploy(m_collector));
    //m_driverAButton.whenPressed(new CollectorIn(m_collector));
    //m_driverAButton.whenReleased(new CollectorStop(m_collector));
    //m_driverAButton.whenPressed(new CollectorDown(m_collector));
    //m_driverAButton.whileHeld(new CollectorBallToShooter(m_collector, m_indexer));
    //m_driverAButton.whenReleased(new StopCollecting(m_collector, m_indexer));
    //m_driverAButton.whenPressed(new CollectorDeploy(m_collector));
    //m_driverAButton.whenReleased(new CollectorRetract(m_collector));
    m_driverRBButton.whileHeld(new ShooterSpin(m_shooter));
    m_driverRBButton.whenReleased(new ShooterStop(m_shooter));
    m_driverLBButton.whenPressed(new HangerBrakeOn(m_hanger));
    m_driverLBButton.whenReleased(new HangerBrakeOff(m_hanger));
    //m_driverBButton.whenPressed(new ConditionalCommand(new IndexerIn(m_indexer), new IndexerStop(m_indexer), m_indexer.getIndexerLast()::get));
    m_driverBButton.whenPressed(new IndexerBallToShooter(m_indexer));
    m_driverBButton.whenReleased(new IndexerStop(m_indexer));
    m_driverXButton.whenPressed(new IndexerBallToCollection(m_indexer));
    m_driverXButton.whenReleased(new IndexerStop(m_indexer));
    //m_driverAButton.whenReleased(new CollectorRetract(m_collector));
    m_driverLSButton.toggleWhenPressed(new ToggleSlowSpeed(m_drivetrain));
    m_driverStButton.whenPressed(new IndexerIn(m_indexer));
    m_driverStButton.whenReleased(new IndexerStop(m_indexer));
    m_driverSeButton.whenPressed(new IndexerOut(m_indexer));
    m_driverSeButton.whenReleased(new IndexerStop(m_indexer));
    m_driverRTrButton.whileHeld(new CollectorBallToShooter(m_collector, m_indexer));
    m_driverRTrButton.whenReleased(new StopCollecting(m_collector, m_indexer));
    //m_driverYButton.whenPressed(new PIDDistanceDrive(m_drivetrain, 25));
    m_driverYButton.whenPressed(new SequentialCommandGroup(new EnableLimelight(), new WaitCommand(1), new PIDRotateDrive(m_drivetrain)));

    m_operatorAButton.whenPressed(new WOFDeploy(m_wheelOfFortune));
    m_operatorAButton.whenReleased(new WOFRetract(m_wheelOfFortune));
    m_operatorLTrButton.whenPressed(new WOFCW(m_wheelOfFortune));
    m_operatorLTrButton.whenReleased(new WOFStop(m_wheelOfFortune));
    m_operatorRTrButton.whenPressed(new WOFCCW(m_wheelOfFortune));
    m_operatorRTrButton.whenReleased(new WOFStop(m_wheelOfFortune));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    
    //return m_autocmd;
    return null;
  }

  public Command getDriveCommand() {
    return m_drive;
  }
}
