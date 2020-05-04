/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Elevator_command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Subsystem_elevator m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem 
   */
  public Elevator_command(Subsystem_elevator subsystem) {
    subsystem_elevator = Subsystem_elevator.getinstance();
    
    addRequirements(Subsystem_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    Subsystem_elevator.elevatorMovmentControl(mathUtil.clamp(subsystem_elevator.PID(RobotContainer.OperatingJoystick.getRawAxis(3)), -1, 1));
     
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {


    Subsystem_elevator.elevatorMovmentControl(0);
      
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}