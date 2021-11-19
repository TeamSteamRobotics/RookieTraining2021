// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  // decleration for the Motor objects - assiged motors values. Motors turn wheels
  WPI_TalonSRX leftFront = new WPI_TalonSRX(1);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(3);

  WPI_TalonSRX rightFront = new WPI_TalonSRX(2);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(4);

  // groupings of wheels for differential drives 
  SpeedControllerGroup speedControllerGroupLeft = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup speedControllerGroupRight = new SpeedControllerGroup(rightFront, rightBack);

  // the motor grouping - combines speeds of left and right motors and takes difference of speeds of left and right sides to turn
  DifferentialDrive diffDrive = new DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight);

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
// drive method calls the arcade drive and regulates motor speed/rotation
  public void drive(double speed, double rotation, boolean squareInputs){
// drives arcade style 

    diffDrive.arcadeDrive(speed, rotation, squareInputs);


  }
  // sets all motor speed to 0, effectively stopping the motors
  public void stop(){
    leftFront.set(0);
    leftBack.set(0);
    rightFront.set(0);
    rightBack.set(0);
  }


}
