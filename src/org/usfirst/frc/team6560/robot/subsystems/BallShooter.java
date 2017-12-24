package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6560.robot.commands.*;
import org.usfirst.frc.team6560.robot.RobotMap.Can;

import com.ctre.CANTalon;

/**
 *
 */
public class BallShooter extends Subsystem {

    CANTalon shooterMotor = new CANTalon(Can.SHOOTER);
    
    public void stopShooter() {
    	shooterMotor.set(0);
    }
    
    public void shootBall() {
    	shooterMotor.set(1.0);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ShootBall());
    }
}

