package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6560.robot.commands.*;
import org.usfirst.frc.team6560.robot.RobotMap.Can;

import com.ctre.CANTalon;

/**
 *
 */
public class BallCollector extends Subsystem {

    CANTalon intakeMotor = new CANTalon(Can.INTAKE);
    
    public void stopIntake() {
    	intakeMotor.set(0);
    }
    
    public void intakeBall() {
    	intakeMotor.set(1.0);
    }
    
    public void dumpBall() {
    	intakeMotor.set(-0.2);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeBall());
    }
}

