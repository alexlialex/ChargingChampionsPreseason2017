package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6560.robot.commands.*;
import org.usfirst.frc.team6560.robot.RobotMap.Can;

import com.ctre.CANTalon;

/**
 *
 */
public class GearCollector extends Subsystem {

    CANTalon suckerMotor = new CANTalon(Can.SUCKER);
    
    public void stopIntake() {
    	suckerMotor.set(0);
    }
    
    public void suckGear() {
    	suckerMotor.set(1.0);
    }
    
    public void shootGear() {
    	suckerMotor.set(-0.2);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new SuckGear());
    }
}

