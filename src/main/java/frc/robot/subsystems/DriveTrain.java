package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Wiring.DeviceNumbers;

/**
 * Represents the drive train subsystem.
 */
public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(DeviceNumbers.DRIVE_LEFT_FRONT_MOTOR);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(DeviceNumbers.DRIVE_RIGHT_FRONT_MOTOR);
  private final WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(DeviceNumbers.DRIVE_LEFT_REAR_MOTOR);
  private final WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(DeviceNumbers.DRIVE_RIGHT_REAR_MOTOR);

  private final DifferentialDrive drive;

  /**
   * Initializes a new instance of the DriveTrain class.
   */
  public DriveTrain() {
    this.leftFrontMotor.follow(this.leftRearMotor);
    this.rightFrontMotor.follow(this.rightRearMotor);

    this.drive = new DifferentialDrive(this.leftRearMotor, this.rightRearMotor);
  }

  /**
   * Drives the robot with the given speed and rotation.
   * 
   * @param xSpeed    The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.
   */
  public void drive(double xSpeed, double zRotation) {
    // TODO: Support reversing the direction at the press of a button...
    // TODO: Support filter pipeline (deadband, etc.)
    this.drive.arcadeDrive(xSpeed, zRotation);
  }

  public void stop() {
    this.drive(0, 0);
  }
}
