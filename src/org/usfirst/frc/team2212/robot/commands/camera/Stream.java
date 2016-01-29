package org.usfirst.frc.team2212.robot.commands.camera;

import org.usfirst.frc.team2212.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Stream extends Command {
	private int session;
	private Image frame;

	public Stream() {
		requires(Robot.camera);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

		session = NIVision.IMAQdxOpenCamera(Robot.camera.getName(),
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(session);
		NIVision.IMAQdxStartAcquisition(session);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		NIVision.IMAQdxGrab(session, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		NIVision.IMAQdxStopAcquisition(session);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
