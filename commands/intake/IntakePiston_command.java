/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Subsystem_intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class IntakePiston_command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Subsystem_intake m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem 
   */
  public IntakePiston_command() {
    subsystem_intake = Subsystem_intake.getinstance();
    
    addRequirements(Subsystem_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      
    Subsystem_intake.Piston(!Subsystem_intake.getPiston());

      
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
 

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
