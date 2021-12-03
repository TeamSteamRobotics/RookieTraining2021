// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase 
{
  //Right Motors
  WPI_TalonSRX frontRight = new WPI_TalonSRX(1);
  WPI_TalonSRX backRight = new WPI_TalonSRX(2);

  //Left Motors
  WPI_TalonSRX frontLeft = new WPI_TalonSRX(3);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(4);

  //Speed Controllers
  SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
  SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);

  //Differential Drive
  DifferentialDrive diffDrive = new DifferentialDrive(right, left);
  
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() 
  {

  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public void drive(double speed, double rotation, boolean squareInputs)
  {


    diffDrive.arcadeDrive(speed, rotation, squareInputs);


  }

  public void stop()
  {
    //Stop Right
    frontRight.set(0);
    backRight.set(0);

    //Stop Left
    frontLeft.set(0);
    backRight.set(0);
  }
}
