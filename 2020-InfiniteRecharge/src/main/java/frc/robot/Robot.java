/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Command m_drive;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    m_robotContainer = new RobotContainer();
    m_drive = m_robotContainer.getDriveCommand();
    //Limelight.setLimelightLeds(1);
    SmartDashboard.putNumber("Shooter RPM Setpoint", 0.0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
   // SmartDashboard.putNumber("Shooter Speed", RobotContainer.m_shooter.getLeftMotorSpeed());
    //SmartDashboard.putNumber("Shooter Speed Percent", RobotContainer.m_shooter.getLeftMotorSpeedPercent());
    SmartDashboard.putNumber("Left Shooter Speed", RobotContainer.m_shooter.getLeftMotorSpeed());
    SmartDashboard.putNumber("Right Shooter Speed", RobotContainer.m_shooter.getRightMotorSpeed());
    SmartDashboard.putNumber("Hanger Velocity Value", RobotContainer.m_hanger.getHangerVelocity());
    SmartDashboard.putNumber("Hanger Encoder Value", RobotContainer.m_hanger.getHangerPosition());
    //SmartDashboard.putNumber("Left Shooter PID Error", RobotContainer.m_shooter.getLeftMotorPIDError());
    //SmartDashboard.putNumber("Right Shooter PID Error", RobotContainer.m_shooter.getRightMotorPIDError());
    //SmartDashboard.putNumber("Left Shooter Raw Speed", RobotContainer.m_shooter.getLeftRawSpeed());
    //SmartDashboard.putNumber("Right Shooter Raw Speed", RobotContainer.m_shooter.getRightRawSpeed());
    //Number[] lime = NetworkTableInstance.getDefault().getEntry("camtran")
    //SmartDashboard.putNumber("Limelight camtran x", (Double) NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getNumberArray(new Number[] {0,0,0,0,0,0})[0]);
    //SmartDashboard.putNumber("Limelight camtran y", (Double) NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getNumberArray(new Number[] {0,0,0,0,0,0})[1]);
    //SmartDashboard.putNumber("Limelight camtran z", (Double) NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getNumberArray(new Number[] {0,0,0,0,0,0})[2]);
    SmartDashboard.putNumber("Navx reported Orentation", RobotContainer.m_drivetrain.getNavx().getAngle());
    //SmartDashboard.putNumber("Left Drive Train Distance", RobotContainer.m_drivetrain.getLeftDistance());
    //SmartDashboard.putNumber("Right Drive Train Distance", RobotContainer.m_drivetrain.getRightDistance());
    SmartDashboard.putBoolean("PID Enabled", RobotContainer.m_drivetrain.pidEnabled);
    SmartDashboard.putBoolean("Limelight Target", Limelight.isTargetAvailable());
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    Limelight.setLimelightLeds(1);
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    Limelight.setLimelightLeds(1);
    RobotContainer.m_drivetrain.zeroEncoders();
    RobotContainer.m_drivetrain.pidEnabled = false;
    RobotContainer.m_drivetrain.positionAchieved = true;
    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    m_drive.schedule();
    //RobotContainer.m_shooter.setLeftMotor(RobotContainer.m_driverController.getRawAxis(2));
    //RobotContainer.m_shooter.setRightMotor(RobotContainer.m_driverController.getRawAxis(3));
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
