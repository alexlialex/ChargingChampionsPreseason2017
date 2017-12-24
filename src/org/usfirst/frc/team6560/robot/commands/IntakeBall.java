package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBall extends Command {

    public IntakeBall() {
        requires(Robot.ballCollector);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ballCollector.intakeBall();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ballCollector.stopIntake();
    }

    protected void interrupted() {
    	end();
    }
}
