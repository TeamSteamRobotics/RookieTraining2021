// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.reflect.Method;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BennyDriveSubsystem extends SubsystemBase {

WPI_TalonSRX BenjaminBoyackLF = new WPI_TalonSRX(1);
WPI_TalonSRX BenjaminBoyackLB = new WPI_TalonSRX(2);
WPI_TalonSRX BenjaminBoyackRF = new WPI_TalonSRX(3);
WPI_TalonSRX BenjaminBoyackRB = new WPI_TalonSRX(0);

SpeedControllerGroup BennyLeft = new SpeedControllerGroup(BenjaminBoyackLB, BenjaminBoyackLF);
SpeedControllerGroup BennyRight = new SpeedControllerGroup(BenjaminBoyackRB, BenjaminBoyackRF);

DifferentialDrive BennyDrive = new DifferentialDrive(BennyLeft, BennyRight);


  /** Creates a new BennySubsystem. */
  public BennyDriveSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void bennyTurnAndDrive(double speed, double turn ){
BennyDrive.arcadeDrive(speed, turn);


  }
public void bennyStop(){
BenjaminBoyackLB.set(0);
BenjaminBoyackLF.set(0);
BenjaminBoyackRB.set(0);
BenjaminBoyackRF.set(0);
}

}
