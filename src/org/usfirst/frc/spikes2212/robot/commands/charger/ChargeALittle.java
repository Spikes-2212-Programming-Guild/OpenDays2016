package org.usfirst.frc.spikes2212.robot.commands.charger;

import static org.usfirst.frc.team2212.robot.Robot.charger;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChargeALittle extends Command {
	public ChargeALittle() {
		requires(charger);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(RobotMap.Timeouts.SMALL_AMOUNT_OF_TIME);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		charger.charge(RobotMap.Speeds.CHARGE);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.charger.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
