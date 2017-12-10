package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap.Can;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	CANTalon leftTopMotor = new CANTalon(Can.LEFT_FWD_MOTOR);
    CANTalon leftBottomMotor = new CANTalon(Can.LEFT_REAR_MOTOR);
    CANTalon rightTopMotor = new CANTalon(Can.RIGHT_FWD_MOTOR);
    CANTalon rightBottomMotor = new CANTalon(Can.RIGHT_REAR_MOTOR);
    RobotDrive drive = new RobotDrive(leftTopMotor, leftBottomMotor, rightTopMotor, rightBottomMotor);

    public void driveWithJoysticks(int magnitude, int direction, int rotation) {
    	drive.mecanumDrive_Polar(magnitude, direction, rotation);
    }

	@Override
	protected void initDefaultCommand() {
		
	}
}

