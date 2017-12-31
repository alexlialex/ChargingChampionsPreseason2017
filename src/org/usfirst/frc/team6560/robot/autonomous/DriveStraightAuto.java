package org.usfirst.frc.team6560.robot.autonomous;

import org.usfirst.frc.team6560.robot.commands.DriveStraightTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Simply drives straight
 */
public class DriveStraightAuto extends CommandGroup {

    public DriveStraightAuto() {
    	addSequential(new DriveStraightTime(1, 2));
    }
}
