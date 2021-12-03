// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.BennyDrive;

public class PortableBlender extends SubsystemBase {
  /** Creates a new PortableBlender. */
  public PortableBlender() {}

WPI_TalonSRX BenjaminBoyackShooter1 = new WPI_TalonSRX(4);
WPI_TalonSRX BenjaminBoyackShooter2 = new WPI_TalonSRX(5);

public void Blend() {
  BenjaminBoyackShooter1.set(2);
  BenjaminBoyackShooter2.set(2); 

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void blenderMotorStop(){
  BenjaminBoyackShooter1.set(0);
  BenjaminBoyackShooter2.set(0);
}


}
