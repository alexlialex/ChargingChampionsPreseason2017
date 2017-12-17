package org.usfirst.frc.team6560.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6560.robot.Robot;

/**
 * Mecanum Drive with joysticks
 */

public class DriveWithJoysticks extends Command {
	double xAxis;
	double yAxis;
	double rotation;

    public DriveWithJoysticks() {
       requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	xAxis = Robot.oi.getLeftXAxis();
    	yAxis = Robot.oi.getLeftYAxis();
    	rotation = Robot.oi.getRightXAxis();
    	Robot.drive.driveWithJoysticks(xAxis, yAxis, rotation);
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
