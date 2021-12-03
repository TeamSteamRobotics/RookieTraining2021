// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class Drive extends CommandBase {
  /** Creates a new Drive. */
  DoubleSupplier speed;
  DoubleSupplier rotation;
  DriveSubsystem driveSubsystem;

  public Drive(DoubleSupplier speed, DoubleSupplier rotation, DriveSubsystem driveSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speed = speed;
    this.rotation = rotation;
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  // Updated every .02 seconds.
  @Override
  public void execute() 
  {
    driveSubsystem.drive(speed.getAsDouble(), rotation.getAsDouble(), true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}