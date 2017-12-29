package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDrive extends Command {
	double visionMotorSpeed;
	double visionWaitTime;
	double minOffset;

    public VisionDrive() {
        requires(Robot.drive);
        requires(Robot.visionControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	visionMotorSpeed = Robot.prefs.getDouble("Vision Motor Speed", 1.0);
		visionWaitTime = Robot.prefs.getDouble("Vision Wait Time", 0.100);
		minOffset = Robot.prefs.getDouble("Minimum Offset", 0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double xOffset = Robot.visionControl.getXOffset();
    	//run based on input above
    	Robot.drive.driveWithJoysticks(xOffset*visionMotorSpeed, 0, 0);
    	Timer.delay(visionWaitTime);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.visionControl.getXOffset())<minOffset;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
