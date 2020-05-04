/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static Joystick leftJoystick = new Joystick(0);
     
  public static Joystick rightsJoystick = new Joystick(1);

  public static XboxController OperatingJoystick = new XboxController(2);

  public static JoystickButton Abutton = new JoystickButton(OperatingJoystick, 1);

  public static JoystickButton Xbutton = new JoystickButton(OperatingJoystick, 3 );

  public static JoystickButton Bbutton = new JoystickButton(OperatingJoystick, 2 );

  public static JoystickButton Ybutton = new JoystickButton(OperatingJoystick, 4 );

  public static JoystickButton LBbutton = new JoystickButton(OperatingJoystick, 5 );

  public static JoystickButton Rbbutton = new JoystickButton(OperatingJoystick, 6 );

  public static JoystickButton l1button = new JoystickButton(OperatingJoystick, 7 );


  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

      

    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Abutton.whileheld(new Mamotaintput_command(()));

    Xbutton.whileheld(new MamotaOuttput_command());

    Bbutton.whileheld(new IntakeCollection_command());

    Ybutton.whileheld(new intakePiston_command());

    LBbutton.whileheld(new Climber_command());

    Rbbutton.whileheld(new IntakeMovment_command(-1))

    l1button.whileheld(new IntakeMovment_command(1))
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
