package org.usfirst.frc.team6560.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6560.robot.Robot;

/**
 * Drives straight for an input time and speed
 */
public class DriveStraightTime extends Command {

	private double time;
	private double speed;
	private Timer timer;
	
	/**
	 * @param timeValue Time in seconds to drive straight
	 * @param speedValue Speed to turn at
	 */
    public DriveStraightTime(double timeValue, double speedValue) {
        requires(Robot.drive);
        time = timeValue;
        speed = speedValue;
    }

    protected void initialize() {
        Robot.drive.gyro.reset();
    	timer = new Timer();
    	timer.reset();
    	timer.start();
    }

    protected void execute() {
    	Robot.drive.driveStraight(speed);
    }
    
    protected boolean isFinished() {
    	return (timer.get() >= time);
    }

    protected void end() {
    	Robot.drive.stopDrive();
    	timer.stop();
    }

    protected void interrupted() {
    	end();
    }
}
