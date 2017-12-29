package org.usfirst.frc.team6560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VisionControl extends Subsystem {
	//NetworkTable table = NetworkTable.getTable("offset");
	double defaultValue = 0;
	
	
	public double getXOffset() {
		//double xOffset = table.getNumber("xOffset", defaultValue);
		//return xOffset;
		return defaultValue;
	}
	
	public double getYOffset() {
		//double yOffset = table.getNumber("yOffset", defaultValue);
		//return yOffset;
		return defaultValue;
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    }
}

