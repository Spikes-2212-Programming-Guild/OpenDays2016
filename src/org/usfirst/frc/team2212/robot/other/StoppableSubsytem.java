package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class StoppableSubsytem extends Subsystem {
	public abstract void stop();

	@Override
	protected final void initDefaultCommand() {
		setDefaultCommand(new Stop(this));
	}

	public static class Stop extends Command {
		public final StoppableSubsytem subsystem;

		/**
		 * @param subsystem
		 */
		public Stop(StoppableSubsytem subsystem) {
			super();
			this.subsystem = subsystem;
		}

		@Override
		protected void initialize() {

		}

		@Override
		protected void execute() {
			subsystem.stop();
		}

		@Override
		protected boolean isFinished() {
			return false;
		}

		@Override
		protected void end() {

		}

		@Override
		protected void interrupted() {
			end();
		}

	}
}
