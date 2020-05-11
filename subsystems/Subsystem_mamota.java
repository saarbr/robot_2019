/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Subsystem_mamota extends SubsystemBase {

    private WPI_TalonSRX MamotaMovment;

    private WPI_VictorSPX MamotaIntake;



    private Encoder encoder;

    private DigitalInput limitSwitch;




    private PIDController pid;

    private static final double Mamota_Kp = 1;

    private static final double Mamota_Ki = 1;
     
    private static final double Mamota_Kd = 1;

    private static Subsystem_mamota subsystem_mamota;



  private Subsystem_mamota() {


    //talon:

    MamotaMovment = new WPI_TalonSRX(Constsnts.MamotaMovment);


    //victor:

    MamotaIntake = new WPI_VictorSPX(Constsnts.MamotaIntake);


    //encoder:

    encoder = new Encoder(Constsnts.Mamota_encoder, false , EncodingType.k4X);

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

 

  // PID

  public double PID(double setpoint){
    return pid.calculate(encoder.getDistance(), 1, -1 ,setpoint);
  }

  public double PIDTime_setPoint(){
    return pid.atsetpoint();
  }


  // limitSwitch function:

  public boolean getLimitswitch(){
    return MamotaMovment.getSensorCollection().isFwdLimitswitchClosed();
  }
  

  // motor current:

  public double MotorCurrent(){
    return MamotaMovment.getStatorCurrent();
  }




  @Override
  public void periodic() {

    //Print sensors:

    SmartDashboard.putNumber("encoder distance:" getDistance());
    SmartDashboard.putboolean("limit Switch:" getLimitswitch());

    // encoder reset by limit switch:

    if (Subsystem_mamota.getLimitswitch()) {
      Subsystem_mamota.resetEncoder();
    }
    
    
    
    
    // This method will be called once per scheduler run
  }
}
