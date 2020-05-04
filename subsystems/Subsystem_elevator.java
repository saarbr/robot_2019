/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_elevator extends SubsystemBase {


  private WPI_TalonSRX elevator_Movment;


  private Encoder encoder;


  private DigitalInput limitSwitch;



  private PIDController pid;

  private static final double elevator_Kp = 1;

  private static final double elevator_Ki = 1;

  private static final double elevator_Kd = 1;
    
    
  private static Subsystem_elevator subsystem_elevator;




  private Subsystem_elevator() {


    //talon:

    elevator_Movment = new WPI_TalonSRX(Constsnts.elevator_Movment);


    //encoder:

    encoder = new Encoder(Constsnts.elevator_encoder, false, EncodingType.k4X);
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


  // limitSwitch function:


  public boolean getLimitswitch(){
    return elevator_Movment.getSensorCollection().isFwdLimitswitchClosed();
  }


  // PID:

  public double PID(double setpoint) {
      return pid.calculate(encoder.getDistance(), setpoint);
  }

  public double PIDTime_setPoint(){
    return pid.atsetpoint();
  }






  @Override
  public void periodic() {

    //הדפסת חיישנים:

    SmartDashboard.putNumber("encoder distance:".getDistance());
    SmartDashboard.putboolean("limit switch:" getLimitswitch());


    // ריסוט אינקודר לפי ליימיט סוויץ:

    if (subsystem_elevator.getLimitswitch()){
      subsystem_elevator.resetEncoder();
    }

    // This method will be called once per scheduler run
  }
}
