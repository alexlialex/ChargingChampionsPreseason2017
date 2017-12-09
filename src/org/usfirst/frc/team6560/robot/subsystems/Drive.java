package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import com.ctre.CANTalon;

/**
 *
 */
public class Drive extends Subsystem {
	
	CANTalon motor1 = new CANTalon(0);
	CANTalon motor2 = new CANTalon(0);
	CANTalon motor3 = new CANTalon(0);
	CANTalon motor4 = new CANTalon(0);
	RobotDrive mecanumDrive = new RobotDrive(motor1, motor2, motor3, motor4);
	
	public void mecanumDriveWithJoysticks(int x, int y) {
		
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

