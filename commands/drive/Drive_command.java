/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Subsystem_Movment;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Drive_command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Subsystem_Movment m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem 
   */
  public Drive_command(Subsystem_Movment subsystem) {
    subsystem_Movment = Subsystem_Movment.getinstance();
    
    addRequirements(Subsystem_Movment);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ExampleSubsystem.RightControl(robotcontainar.rightJoystick.getY());
    ExampleSubsystem.LeftControl(robotcontainar.leftJoystick.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ExampleSubsystem.RightControl(0);
    ExampleSubsystem.LeftControl(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
