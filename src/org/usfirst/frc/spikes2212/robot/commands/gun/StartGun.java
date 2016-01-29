package org.usfirst.frc.spikes2212.robot.commands.gun;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartGun extends Command {

	private double leftSpeed;
	private double rightSpeed;

	public StartGun(double voltage) {
		this(voltage, voltage);
	}

	public StartGun(double leftVoltage, double rightVoltage) {
		requires(Robot.gun);
		this.leftSpeed = leftVoltage;
		this.rightSpeed = rightVoltage;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.gun.shoot(leftSpeed,rightSpeed);
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
	}
}
