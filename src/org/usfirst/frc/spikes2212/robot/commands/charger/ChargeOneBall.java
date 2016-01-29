package org.usfirst.frc.spikes2212.robot.commands.charger;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.other.NonDumbCommand;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChargeOneBall extends NonDumbCommand {

	public ChargeOneBall() {
		requires(Robot.charger);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.charger.isBallAtTop();
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

	@Override
	public void run() {
		Robot.charger.charge(RobotMap.Speeds.CHARGE);
	}
}
