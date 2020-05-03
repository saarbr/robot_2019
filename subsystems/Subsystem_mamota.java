/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_mamota extends SubsystemBase {

    WPI_TalonSRX MamotaMovment;

    WPI_VictorSPX MamotaIntake;



    Encoder encoder;

    DigitalInput limitSwitch;




    PIDController pid;

    double Mamota_Kp = 1;

    double Mamota_Ki = 1;
     
    double Mamota_Kd = 1;

    private static Subsystem_mamota subsystem_mamota;



  private Subsystem_mamota() {


    //talon:

    MamotaMovment = new WPI_TalonSRX(1);


    //victor:

    MamotaIntake = new WPI_VictorSPX(2);


    //encoder:

    encoder = new Encoder(0, 1, false , EncodingType.k4X);

    encoder.setDistancePerPulse(1);


    //limitSwitch:

    MamotaMovment.configForwardLimitSwitchSource(limitSwitchSource.RemoteTalonSRX, limitSwitchNormal.Normallyopen);


    //PID:

    pid = new PIDController(Mamota_Kp, Mamota_Ki , Mamota_Kd);

    pid.setTolerance(1);


  }


  // slington

  public static Subsystem_mamota getinstance() {
    if (subsystem_mamota == null) { 
      subsystem_mamota = new Subsystem_mamota();
    }
    return subsystem_mamota;
  }



  //momota conrtol function

  public void MamotaMovment_Control(double power) {
    MamotaMovment.set(ControlMode.PercentOutput, power);
  }


  // mamota intake control function:

  public void MamotaIntake_Control(double power) {
    MamotaIntake.set(ControlMode.PercentOutput , power);
  }


  // encoder functions:

  public void resetEncoder(){
    encoder.reset();
  }

  public double getDistance(){
    return encoder.getDistance();
  }

  public double getRate(){
    return encoder.getRate()
  }


  // PID

  public double PID(double setpoint){
    return pid.caculate(encoder.getDistance(), setpoint)
  }


  // limitSwitch function:

  public boolean getLimitswitch(){
    return MamotaMovment.getSensorCollection().isFwdLimitswitchClosed();
  }




  @Override
  public void periodic() {

    // הדפסת חיישנים:

    SmartDashboard.putNumber("encoder distance:".getDistance());
    SmartDashboard.putNumber("encoder rate:".getRate());
    SmartDashboard.putboolean("limit Switch:".getLimitswitch());

    //ריסוט אינקודר לפי לימיט סוויץ:

    if (Subsystem_mamota.getLimitswitch() == true) {
      Subsystem_mamota.resetEncoder();
    }
    
    
    
    
    // This method will be called once per scheduler run
  }
}
