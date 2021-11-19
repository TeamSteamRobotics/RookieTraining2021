// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  //Motors made in the next lines that turn the wheels.
  WPI_TalonSRX leftBack = new WPI_TalonSRX(0) ;
  WPI_TalonSRX rightBack = new WPI_TalonSRX(1);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(2);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(3);
  //SpeedControllerGroups make it so the wheels are able to move at the same time in groups.
  SpeedControllerGroup speedControllerGroupLeft = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup speedControllerGroupRight = new SpeedControllerGroup(rightFront, rightBack);
  //DifferentialDrive make it so we can control the movement of the left and right drive trains to turn.
  //If the left side moves faster than the right, it turns right. If the right side moves faster than the left, it turns left. If they are the same, it goes straight.
  DifferentialDrive diffDrive = new DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight) ;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}
//Starts and controls the movement of the wheels based on inputs.
public void drive(double speed, double turn, boolean squareInputs) {
  //Drives Arcade style.
  diffDrive.arcadeDrive(speed, turn, squareInputs);
}

public void stop() {
//Stops the movement of the wheels by setting the motor speeds to 0. Stops the drive train.
  diffDrive.arcadeDrive(0, 0);

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
