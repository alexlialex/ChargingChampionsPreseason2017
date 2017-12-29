package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Spin robot until the gyro reads a given angle. Assumes angle is not 0
 * 
 * If input angle is greater than 0, turn clockwise
 * If input angle is less than 0, turn counterclockwise
 */
public class TurnToAngle extends Command {
	private int angle;
	private double speed;
	private Timer timer;

	/**
	 * @param angleToTurn Desired gyro heading
	 * @param speedValue Speed to spin the robot
	 */
	public TurnToAngle(int angleToTurn, double speedValue) {
		requires(Robot.drive);
		angle = angleToTurn;
		speed = speedValue;
	}

	protected void initialize() {
		Robot.drive.gyro.reset();
		timer = new Timer();
		timer.reset();
		timer.start();
	}

	protected void execute() {
		if (angle > 0)
			Robot.drive.spinRight(speed);
		if (angle < 0)
			Robot.drive.spinLeft(speed);
	}

	protected boolean isFinished() {
		if (angle > 0) 
			return Robot.drive.getGyroAngle() >= angle || timer.get() >= 2.5;
		else
			return Robot.drive.getGyroAngle() <= angle || timer.get() >= 2.5;
	}

	protected void end() {
		Robot.drive.stopDrive();
	}

	protected void interrupted() {
		end();
	}
}