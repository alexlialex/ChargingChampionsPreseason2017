package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDrive extends Command {

    public VisionDrive() {
        requires(Robot.drive);
        requires(Robot.visionControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double xOffset = Robot.visionControl.getXOffset();
    	//run based on input above
    	Robot.drive.driveWithJoysticks(xOffset, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.visionControl.getXOffset())<0.1;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
