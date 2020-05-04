/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //movment:

    public static final int left_motor1 = 1;
    public static final int left_motor2 = 2;

    public static final int right_motor1 = 3;
    public static final int right_motor2 = 4;

    //mamota:

    public static final int MamotaMovment = 5;

    public static final int MamotaIntake = 6;

    public static final int Mamota_encoder = 1;

    
    //intake:

    public static final int intakeMovment1 = 7;

    public static final int intakeMovment2 = 8;

    public static final int intakeCollection = 9;

    public static final int intake_solenoid = 1;

    public static final int intake_encoder = 2;



    //elevator:

    public static final int elevator_Movment = 10;

    public static final int elevator_encoder = 3;


    //climber:

    public static final int climber_doubleSolenoid = 2, 3;


}
