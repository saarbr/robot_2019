/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem_intake extends SubsystemBase {
    
    private Solenoid solenoid1;

    private WPI_TalonSRX intakeMovment1;

    private WPI_TalonSRX intakeMovment2;

    private WPI_VictorSPX intakeCollection;


    private Encoder encoder;


    private DigitalInput limitSwitch;


    private PIDController pid;

    private static final double intake_Kp = 1;

    private static final double intake_Ki = 1;
     
    private static final double intake_Kd = 1;


    private static Subsystem_intake subsystem_intake;

  private Subsystem_intake() {
      // solenoid:
      
      solenoid1 = new Solenoid(Constsnts.intake_solenoid);


      // talons:

      intakeMovment1 = new WPI_TalonSRX(Constsnts.intakeMovment1);
      intakeMovment2 = new WPI_TalonSRX(Constsnts.intakeMovment2);
      intakeMovment2.follow(intakeMovment1);
      intakeMovment1.setInverted(true);


      // viktor:

      intakeCollection = new WPI_VictorSPX(Constsnts.intakeCollection);


      //encoder:

      encoder = new Encoder(Constsnts.intake_encoder, false, EncodingType.k4X);

      encoder.setDistancePerPulse(1);


      //limitSwitch:

      intakeMovment1.configForwardLimitSwitchSource(limitSwitchSource.RemoteTalonSRX, limitSwitchNormal.Normallyopen);


      // PID:

      pid = new PIDController(intake_Kp, intake_Ki , intake_Kd);

      pid.setTolerance(1);
  }


  //slington:

    public static Subsystem_intake getinstance() {
      if (subsystems_intake == null) {
          subsystems_intake = new Subsystem_intake();
      }
      return subsystems_intake;
    }



  // piston functions:

  public void Piston(boolean t){
      solenoid1.set(t);
  }

  public boolean getPiston(){
    return solenoid1.get();
  }


  // intake control function:

  public void IntakeControl(double power){
      intakeMovment1.set(ControlMode.PercentOutput, power)
  }


  // intake collection function:

  public void intakeCollection(double power) { 
      intakeCollection.set(ControlMode.PercentOutput, power);
  }



  // encoder functions:
  
  public void resetEncoder() {
      encoder.reset();
  }

  public double getDistance(){
      return encoder.getDistance();
  }



  // limitswitch function:

  public boolean getLimitswitch(){
      return intakeMovment1.getSensorCollection().isFwdLimitswitchClosed();
  }

  

  //PID:
  
  public double PID(double setpoint) {
      return pid.calculate(encoder.getDistance(), setpoint);
  }
  
  public double PIDTime_setPoint(){
    return pid.atsetpoint();
  }





  @Override
  public void periodic() {

      // הדפסת חיישנים:

      SmartDashboard.putNumber("encoder distance:".getDistance());
      SmartDashboard.putboolean("limit Switch:".getLimitswitch());

      //ריסוט אינקודר לפי לימיט סוויץ:

      if (Subsystem_intake.getLimitswitch()){
          subsystem_intake.resetEncoder();
      }
    
    // This method will be called once per scheduler run
  }
}
