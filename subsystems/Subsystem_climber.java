/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_climber extends SubsystemBase {

    DoubleSolenoid doubleSolenoid;


    private static Subsystem_climber subsystem_climber;



  private Subsystem_climber() {



    //doubleSolenoid:

    doubleSolenoid = new DoubleSolenoid(1, 2);

  }


  // doubleSolenoid functions:

  public void piston_Forward(){
    doubleSolenoid.set(value.kForward);
  }

  public void piston_reverse(){
      doubleSolenoid.set(value.kReverse);
  }

  public void piston_Off(){
      doubleSolenoid.set(value.koff);
  }


  // slington:

  public static Subsystem_climber getinstance(){

    if (subsystem_climber == null){
      subsystem_climber = new Subsystem_climber();
    }
      return subsystem_climber;
    } 







  @Override
  public void periodic() {
    
    
    
    
    // This method will be called once per scheduler run
  }
}
