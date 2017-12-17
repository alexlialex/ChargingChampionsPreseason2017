package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SuckGear extends Command {

    public SuckGear() {
        requires(Robot.gearCollector);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearCollector.suckGear();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.gearCollector.stopIntake();
    }

    protected void interrupted() {
    	end();
    }
}
