
package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.other.SpeedControllersGroup;
import org.usfirst.frc.team2212.robot.other.StoppableSubsytem;
import org.usfirst.frc.team2212.robot.subsystems.Camera;
import org.usfirst.frc.team2212.robot.subsystems.Charger;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2212.robot.subsystems.Gun;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import static org.usfirst.frc.team2212.robot.RobotMap.Ports.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Camera camera;
	public static Gun gun;
	public static Charger charger;
    Command autonomousCommand;
    StoppableSubsytem[] allStoppableSubsystems;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain(
				PortsDrive.LEFT_FRONT, PortsDrive.RIGHT_FRONT,
				PortsDrive.LEFT_REAR, PortsDrive.RIGHT_REAR);
		camera = new Camera("vision");
		charger = new Charger(PortsCharger.LEFT, PortsCharger.RIGHT,
				PortsCharger.LIMIT);
		gun = new Gun(PortsGun.LEFT, PortsGun.RIGHT);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
