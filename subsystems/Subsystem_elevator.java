/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_elevator extends SubsystemBase {


    WPI_TalonSRX elevator_Movment;


    Encoder encoder;


    DigitalInput limitSwitch;



    PIDController pid;

    double elevator_Kp = 1;

    double elevator_Ki = 1;

    double elevator_Kd = 1;
    
    
    private static Subsystem_elevator subsystem_elevator;




  private Subsystem_elevator() {


    //talon:

    elevator_Movment = new WPI_TalonSRX(1);


    //encoder:

    encoder = new Encoder(0, 1 false, EncodingType.k4X);
    encoder.setDistancePerPules(1);


    //limitSwitch:

    elevator_Movment.configForwardLimitSwitchSource(limitSwitchSource.RemoteTalonSRX, limitSwitchNormal.Normallyopen);


    // PID:

    pid = new PIDController(elevator_Kp, elevator_Ki , elevator_Kd);

    pid.setTolerance(1);

  }



  //elevator movment control function:

  public void elevatorMovmentControl(double power) {
      elevator_Movment.set(ControlMode.PercentOutput, power);
  }

  //slington:

  public static Subsystem_elevator getinstance(){
    if (subsystem_elevator == null){
      subsystem_elevator = new Subsystem_elevator();
    }
    return subsystem_elevator;
  }

  //endcoder functions:

  public void resetEncoder(){
    return encoder.reset();
  }

  public double getDistance(){
    return encoder.getDistance();
  }

  public double getRate(){
    return encoder.getRate();
  }


  // limitSwitch function:


  public boolean getLimitswitch(){
    return elevator_Movment.getSensorCollection().isFwdLimitswitchClosed();
  }


  // PID:

  public double PID(double setpoint) {
      return pid.calculate(encoder.getDistance(), setpoint);
  }






  @Override
  public void periodic() {

    //הדפסת חיישנים:

    SmartDashboard.putNumber("encoder distance:".getDistance());
    SmartDashboard.putNumber("encoder rate:".getRate());
    SmartDashboard.putboolean("limit switch:" getLimitswitch());


    // ריסוט אינקודר לפי ליימיט סוויץ:

    if (subsystem_elevator.getLimitswitch() == true){
      subsystem_elevator.resetEncoder();
    }


    // This method will be called once per scheduler run
  }
}
