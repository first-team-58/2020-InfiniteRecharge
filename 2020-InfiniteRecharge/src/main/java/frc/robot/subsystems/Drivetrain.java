/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Limelight;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX driveTrainLeftFront, driveTrainRightFront;
    private WPI_TalonFX driveTrainLeftRear, driveTrainRightRear;
    private Solenoid driveSolenoid;

    private DifferentialDrive drive;

    private AHRS navx;

    public double P = 0.06, I = 0.01, D = 0.0;
    public double Pr = 0.01, Ir = 0.004, Dr = 0;
    public int pidPosCnt = 0, pidRotCnt = 0;

    private boolean slowSpeed = false;
    private double integral, previous_error;
    public double rotationSetpoint = 0, distanceSetpoint = 0;
    double rcw, rcw_prev, pspd, pspd_prev;
    public boolean positionAchieved = false;

    public boolean pidEnabled = false;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    navx = new AHRS();

    driveTrainRightFront = new WPI_TalonFX(Constants.driveTrainRightFront);
    driveTrainRightRear = new WPI_TalonFX(Constants.driveTrainRightRear);
    driveTrainLeftFront = new WPI_TalonFX(Constants.driveTrainLeftFront);
    driveTrainLeftRear = new WPI_TalonFX(Constants.driveTrainLeftRear);

    driveTrainLeftFront.configOpenloopRamp(2);
    driveTrainLeftRear.configOpenloopRamp(2);
    driveTrainRightFront.configOpenloopRamp(2);
    driveTrainRightRear.configOpenloopRamp(2);

    driveSolenoid = new Solenoid(Constants.driveTrainSolenoid);

    // driveTrainRightRear.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    // driveTrainLeftRear.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    // //driveTrainLeftRear.setNeutralMode(NeutralMode.Coast);
    // //driveTrainRightRear.setNeutralMode(NeutralMode.Coast);
    
    // driveTrainLeftRear.setSensorPhase(true);
    // driveTrainRightRear.setSensorPhase(false);

    // driveTrainLeftRear.configNominalOutputForward(0);
    // driveTrainLeftRear.configNominalOutputReverse(0);
    // driveTrainLeftRear.configPeakOutputForward(1);
    // driveTrainLeftRear.configPeakOutputReverse(-1);
    
    // driveTrainRightRear.configNominalOutputForward(0);
    // driveTrainRightRear.configNominalOutputReverse(0);
    // driveTrainRightRear.configPeakOutputForward(1);
    // driveTrainRightRear.configPeakOutputReverse(-1);

    // //driveTrainLeftRear.config_kF(0, Constants.shooterL_kF);
    // driveTrainLeftRear.config_kP(0, P);
    // driveTrainLeftRear.config_kI(0, Constants.shooterL_kI);
    // driveTrainLeftRear.config_kD(0, Constants.shooterL_kD);
    // //leftMotor.configClosedloopRamp(10.0);
    // driveTrainLeftRear.config_IntegralZone(0, 300);

    // //driveTrainRightRear.config_kF(0, Constants.shooterL_kF);
    // driveTrainRightRear.config_kP(0, P);
    // driveTrainRightRear.config_kI(0, I);
    // driveTrainRightRear.config_kD(0, D);
    // //leftMotor.configClosedloopRamp(10.0);
    // driveTrainRightRear.config_IntegralZone(0, 300);


    driveTrainLeftFront.follow(driveTrainLeftRear);
    driveTrainRightFront.follow(driveTrainRightRear);

    drive = new DifferentialDrive(driveTrainLeftRear, driveTrainRightRear);
    driveSolenoid.set(Constants.driveSolenoidSlow);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double move, double rotate) {
      drive.arcadeDrive(move, rotate);
  }

  public void toggleSlowSpeed() {
    //slowSpeed = !slowSpeed;
    driveSolenoid.set(!driveSolenoid.get());
    zeroEncoders();
  }

  public void setSlowSpeed(boolean state) {
    driveSolenoid.set(state);
    zeroEncoders();
  }

  public boolean getSlowSpeed() {
    return slowSpeed;
  }

  public void setDriveStates(TrapezoidProfile.State left, TrapezoidProfile.State right) {
    System.out.println("Test");
    driveTrainLeftRear.set(TalonFXControlMode.Position, left.position);
    driveTrainRightRear.set(TalonFXControlMode.Position, right.position);
  }

public double getLeftDistance() {
  double raw = (driveTrainLeftFront.getSelectedSensorPosition() + driveTrainLeftRear.getSelectedSensorPosition()) /2;
  double actual;
  if(driveSolenoid.get()) {
    //slow ratio
    double ratio = 12.86;
    double circumference = 15.70796;
    double cpr = 1024;
    actual = ((raw / cpr) / ratio) * circumference;
  } else {
    //fast ratio
    double ratio = 6.25;
    double circumference = 15.70796;
    double cpr = 1024;
    actual = ((raw / cpr) / ratio) * circumference;
  }

  return -1.0 * actual;
}

public void zeroEncoders() {
  driveTrainLeftFront.getSensorCollection().setIntegratedSensorPosition(0.0, 100);
  driveTrainLeftRear.getSensorCollection().setIntegratedSensorPosition(0.0, 100);
  driveTrainRightFront.getSensorCollection().setIntegratedSensorPosition(0.0, 100);
  driveTrainRightRear.getSensorCollection().setIntegratedSensorPosition(0.0, 100);
}

public double getRightDistance() {
  double raw = (driveTrainRightFront.getSelectedSensorPosition() + driveTrainRightRear.getSelectedSensorPosition()) /2;
  double actual;
  if(driveSolenoid.get()) {
    //slow ratio
    double ratio = 12.86;
    double circumference = 15.70796;
    double cpr = 1024;
    actual = ((raw / cpr) / ratio) * circumference;
  } else {
    //fast ratio
    double ratio = 6.25;
    double circumference = 15.70796;
    double cpr = 1024;
    actual = ((raw / cpr) / ratio) * circumference;
  }

  return actual;
}

public void pidDriveRotate(double speed) {
  PIDRotation();
  drive(speed, rcw);
}

public void pidDrivePosition() {
  PIDPosition();
  drive(-1.0 * pspd, 0);
}

private void PIDRotation() {
    double error = rotationSetpoint - navx.getAngle();
		this.integral += (error * .02);
		double derivative = (error - this.previous_error) / .02;
		//this.rcw = Pr * error + Ir * this.integral + Dr * derivative;
    
    double new_rcw = Constants.driveRotationalP * error + Constants.driveRotationalI * this.integral + Constants.driveRotationalD * derivative;
    rcw_prev = rcw;
    if(new_rcw > (rcw + Constants.driveRotationalChangeLimit)) {
      rcw = rcw + Constants.driveRotationalChangeLimit;
    } else if (new_rcw < (rcw - Constants.driveRotationalChangeLimit)) {
      rcw = rcw - Constants.driveRotationalChangeLimit;
    } else {
      this.rcw = new_rcw;
    }
  
    if(rcw > Constants.driveRotationalLimit) {
      rcw = Constants.driveRotationalLimit;
    } else if (rcw < - 1.0 *Constants.driveRotationalLimit) {
      rcw = -1.0 * Constants.driveRotationalLimit;
    }

    SmartDashboard.putNumber("PIDPosition error", error);
    SmartDashboard.putNumber("PIDPosition integral", integral);
    //SmartDashboard.putNumber("PIDPosition der", derivative);
    SmartDashboard.putNumber("PIDPosition pos", navx.getAngle());
    SmartDashboard.putNumber("PIDPosition out", rcw);
    SmartDashboard.putNumber("PIDPosition target", rotationSetpoint);
    
    if(Math.abs(error) < Constants.driveRotationalDeadzone && Math.abs(previous_error) < Constants.driveRotationalDeadzone) {
      pidRotCnt++;
      if(pidRotCnt > Constants.driveRotationalCountsToFinish) {
        positionAchieved = true;
        pidEnabled = false;
        Limelight.setLimelightLeds(1);
      }
    } else {
      pidRotCnt = 0;
    }
    this.previous_error = error;
}

private void PIDPosition() {
  double error = distanceSetpoint - ((getRightDistance() + getLeftDistance())/2);
  // if((this.integral + (error * .02)) > .3) {
  //   this.integral = .3;
  // } else if((this.integral + (error * .02) < -.3)) {
  //   this.integral = -.3;
  // } else {
    this.integral += (error * .02);
  //}
  double derivative = (error - this.previous_error) / .02;
  double new_pspd = Constants.drivePositionalP * error + Constants.drivePositionalI * this.integral + Constants.drivePositionalD * derivative;
  pspd_prev = pspd;
  if(new_pspd > (pspd + Constants.drivePositionalChangeLimit)) {
    pspd = pspd + Constants.drivePositionalChangeLimit;
  } else if (new_pspd < (pspd - Constants.drivePositionalChangeLimit)) {
    pspd = pspd - Constants.drivePositionalChangeLimit;
  } else {
    this.pspd = new_pspd;
  }

  if(pspd > Constants.drivePositionalLimit) {
    pspd = Constants.drivePositionalLimit;
  } else if (pspd < (-1.0 * Constants.drivePositionalLimit)) {
    pspd = ( -1.0 * Constants.drivePositionalLimit);
  }
  
  SmartDashboard.putNumber("PIDPosition error", error);
  SmartDashboard.putNumber("PIDPosition integral", integral);
  SmartDashboard.putNumber("PIDPosition der", derivative);
  SmartDashboard.putNumber("PIDPosition pos", ((getRightDistance() + getLeftDistance())/2));
  if(error < Constants.drivePositionalDeadzone && previous_error < Constants.drivePositionalDeadzone) {
    pidPosCnt++;
    if(pidPosCnt > Constants.drivePositionalCountsToFinish) {
      positionAchieved = true;
      pidEnabled = false;
      pspd = 0;
      pspd_prev = 0;
      //System.out.println("position achieved");
    }
  } else {
    pidPosCnt = 0;
  }
  this.previous_error = error;
}

  public double getSpeed() {
    //SmartDashboard.putNumber("DTRF", driveTrainRightFront.getSensorCollection().getIntegratedSensorVelocity());
    //SmartDashboard.putNumber("DTRR", driveTrainRightRear.getSensorCollection().getIntegratedSensorVelocity());
    //SmartDashboard.putNumber("DTLF", driveTrainLeftFront.getSensorCollection().getIntegratedSensorVelocity());
    //SmartDashboard.putNumber("DTLR", driveTrainLeftRear.getSensorCollection().getIntegratedSensorVelocity());
    

    double speed = 
    (-1.0 * driveTrainLeftFront.getSensorCollection().getIntegratedSensorVelocity()) + 
    //(-1.0 * driveTrainLeftRear.getSensorCollection().getIntegratedSensorVelocity()) + 
    driveTrainRightFront.getSensorCollection().getIntegratedSensorVelocity() ;//+
    //driveTrainRightRear.getSensorCollection().getIntegratedSensorVelocity();

    return speed / 4.0 ;
  }

  public AHRS getNavx() {
    return navx;
  }
}
