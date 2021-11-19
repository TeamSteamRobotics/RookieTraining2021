// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BennyDriveSubsystem;

public class BennyDrive extends CommandBase {
  /** Creates a new BennyDrive. */

  DoubleSupplier forwardSpeed;
  DoubleSupplier turn;
  BennyDriveSubsystem drive;
// Global Drive Variables ^.

  public BennyDrive(DoubleSupplier turn, DoubleSupplier forwardSpeed, BennyDriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
this.forwardSpeed = forwardSpeed;
this.turn = turn;
this.drive = drive;
addRequirements(drive);
// Variables only for this method ^.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
// Calls the DriveSubsystem and moves robot based on variables
drive.bennyTurnAndDrive(forwardSpeed.getAsDouble(), turn.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
