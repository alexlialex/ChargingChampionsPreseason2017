package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.commands.GetXCoordinate;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionControl extends Subsystem {
	NetworkTable table = NetworkTable.getTable("coordinates");
	double defaultValue = 0;
	
	
	public double getXCoordinate() {
		double xCoordinate = table.getNumber("x", defaultValue);
		return xCoordinate;
	}
	
	public double getYCoordinate() {
		double yCoordinate = table.getNumber("y", defaultValue);
		return yCoordinate;
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new GetXCoordinate());
    }
}

