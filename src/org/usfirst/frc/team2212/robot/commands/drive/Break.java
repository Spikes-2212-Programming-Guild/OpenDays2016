package org.usfirst.frc.team2212.robot.commands.drive;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.drivetrain;
/**
 *
 */
public class Break extends Command {


    public Break() {
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }


	@Override
	protected void execute() {
		drivetrain.stop();
	}
}
