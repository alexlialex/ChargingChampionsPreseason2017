package org.usfirst.frc.team6560.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6560.robot.Robot;

/**
 * Mecanum Drive with joysticks and slider
 */

public class DriveWithJoysticksAndSlider extends Command {
	double xAxis;
	double yAxis;
	double rotation;
	double magnitude;

    public DriveWithJoysticksAndSlider() {
       requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	xAxis = Robot.oi.getLeftXAxis();
    	yAxis = Robot.oi.getLeftYAxis();
    	rotation = Robot.oi.getRightXAxis();
    	magnitude = ((Robot.oi.getSecondarySlider() + 1.0) / 2.0);
    	Robot.drive.driveWithJoysticks(xAxis*magnitude, yAxis*magnitude, rotation*magnitude);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.stopDrive();
    }

    protected void interrupted() {
    	end();
    }
}
