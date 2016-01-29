package org.usfirst.frc.spikes2212.robot.commands.gun;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickStartGun extends Command {

	public JoystickStartGun() {
		requires(Robot.gun);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double y = Robot.oi.getMaxThrottle();
		Robot.gun.shoot(y * RobotMap.Speeds.SHOOT, y * RobotMap.Speeds.SHOOT);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.gun.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}