package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap.Can;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6560.robot.commands.*;

public class Drive extends Subsystem {

	CANTalon leftTopMotor = new CANTalon(Can.LEFT_FWD_MOTOR);
    CANTalon leftBottomMotor = new CANTalon(Can.LEFT_REAR_MOTOR);
    CANTalon rightTopMotor = new CANTalon(Can.RIGHT_FWD_MOTOR);
    CANTalon rightBottomMotor = new CANTalon(Can.RIGHT_REAR_MOTOR);
    
    public RobotDrive drivetrain = new RobotDrive(leftTopMotor, leftBottomMotor, rightTopMotor, rightBottomMotor);
    public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    public static final double kP = 0.01; //Proportionality constant
    
    /**
     * Recalibrates gyro and sets current angle to 0
     */
    public Drive() {
    	gyro.calibrate();
    	gyro.reset();
    }
    
    /**
     * Mecanum drive with input from the joystick
     * 
     * @param strafe Left/right movement value
     * @param forward Forward/backward movement value
     * @param rotation Rotation value
     */
    public void driveWithJoysticks(double strafe, double forward, double rotation) {
    	drivetrain.mecanumDrive_Cartesian(strafe, forward, rotation, 0);
    }
    
    /**
     * Stops all motors
     */
    public void stopDrive() {
    	leftTopMotor.set(0);
    	leftBottomMotor.set(0);
    	rightTopMotor.set(0);
    	rightBottomMotor.set(0);
    }
    
    /**
     * Gyro assisted straight movement
     * @param Speed value scaled from 0.0 - 1.0 
     */
    public void driveStraight(double speed) {
    	speed = Math.abs(speed);
      	int angle = getGyroAngle();
    	drivetrain.drive(speed, angle * kP);
    	Timer.delay(0.004); //4 millisecond delay to allow for gyro to calibrate
    }
    
    public void spinLeft(double speed) {
    	drivetrain.mecanumDrive_Cartesian(0, 0, -speed, 0);
    }
    
    public void spinRight(double speed) {
    	drivetrain.mecanumDrive_Cartesian(0, 0, speed, 0);
    }

    /**
     * @return Current gyro header
     */
    public int getGyroAngle() {
    	return (int)Math.round(gyro.getAngle());
    }

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoysticks());
	}
}

