/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_Movment extends SubsystemBase {

  CANSparkMax left_motor1;

  CANSparkMax left_motor2;

  CANSparkMax right_motor1;

  CANSparkMax right_motor2;

  private static Subsystem_Movment subsystem_Movment;

  private Subsystem_Movment() {


    // left motors control (CANSparkMax)

    left_motor1 = new CANSparkMax(1, MotorType.kBrushless);
    left_motor2 = new CANSparkMax(2, MotorType.kBrushless);
    left_motor1.setInverted(true);
    left_motor2.follow(left_motor1);
    left_motor1.setIdleMode(IdleMode.kBreak);
    left_motor2.setIdleMode(IdleMode.kBreak);


    // right motors control (CANSparkMax)

    right_motor1 = new CANSparkMax(3, MotorType.kBrushless);
    right_motor2 = new CANSparkMax(4, MotorType.kBrushless);
    right_motor2.follow(right_motor1);
    right_motor1.setIdleMode(IdleMode.kBreak);
    right_motor2.setIdleMode(IdleMode.kBreak);



  }


  // slington:

  public static Subsystem_Movment getinstance(){
    if (subsystem_Movment == null){

      subsystem_Movment = new Subsystem_Movment();
    }
      return subsystem_Movment;
  }

  

   // right motor control function:
 
   public void RightControl(double power) {
    right_motor1.set(power);
  }


  //left motor control function:

   public void LeftControl(double power){
     left_motor1.set(power);
   }


    // קבלת ערכים של מנוע שמאל:

    public boolean GetLeftMotorsValue(){
      return left_motor1.get();
    }


    // קבלת ערכים של מנוע ימין:

    public boolean GetRightMotorsValue(){
      return right_motor1.get();
    }






  @Override
  public void periodic() {

    // הדפסת ערכי מנועים:

    SmartDashboard.putBoolean("Left motors value:", GetLeftMotorsValue());
    SmartDashboard.putBoolean("Right motors value:", GetRightMotorsValue());
    
    
    
    // This method will be called once per scheduler run
  }
}
