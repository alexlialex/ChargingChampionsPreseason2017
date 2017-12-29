
package org.usfirst.frc.team6560.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team6560.robot.subsystems.*;
import org.usfirst.frc.team6560.robot.commands.*;
import org.usfirst.frc.team6560.robot.autonomus.*;

public class Robot extends IterativeRobot {
	
	public static Preferences prefs = Preferences.getInstance();

	public static OI oi;
	public static Drive drive;
	public static BallCollector ballCollector;
	public static BallShooter ballShooter;
	public static VisionControl visionControl;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		
		//the code below has been moved to the initialization of the VisionDrive command so that it updates with every call of the command
		//double visionMotorSpeed = prefs.getDouble("Vision Motor Speed", 1.0);
		//double visionWaitTime = prefs.getDouble("Vision Wait Time", 100);
		//double minOffset = prefs.getDouble("Minimum Offset", 0.1);
		
		//Initialize subsystems
		drive = new Drive();
		drive.drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		ballCollector = new BallCollector();
		ballShooter = new BallShooter();
		visionControl = new VisionControl();
    
		//SmartDashboard.putData(Scheduler.getInstance());
		//SmartDashboard.putData("Intake Ball", new IntakeBall());
		//SmartDashboard.putData("Shoot Ball", new ShootBall());
		//SmartDashboard.putData("Vision Drive", new VisionDrive());
		//SmartDashboard.putData("Get X Offset", new SmartDashboardPutXOffset());
		
		//Add autonomous programs to chooser
		chooser.addDefault("Drive straight", new DriveStraightAuto());
		SmartDashboard.putData("Auto mode chooser", chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
