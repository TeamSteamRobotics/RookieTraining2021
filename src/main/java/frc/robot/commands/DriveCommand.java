// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  //driveSubsystem1 isn't equal to new driveSubsystem because we're using as an empty box. speed1 and turn1 are filling the box.
  DriveSubsystem driveSubsystem1;
  DoubleSupplier speed1;
  DoubleSupplier turn1;
  /** Creates a new DriveCommand. */
  public DriveCommand(DriveSubsystem driveSubsystem2, DoubleSupplier speed2, DoubleSupplier turn2) {
    //Both driveSubsystems, speeds, and turns have to be equal so they can be used in the code later.
    driveSubsystem1 = driveSubsystem2;
    speed1 = speed2;
    turn1 = turn2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //driveSubsystem1 is based on the speed and turn amount.
    driveSubsystem1.drive(speed1.getAsDouble(), turn1.getAsDouble(),true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem1.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
