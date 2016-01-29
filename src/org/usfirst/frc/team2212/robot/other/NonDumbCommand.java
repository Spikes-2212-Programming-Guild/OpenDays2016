package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.command.Command;

public abstract class NonDumbCommand extends Command implements Runnable {
	private boolean firstTime = true;

	@Override
	protected final void execute() {
		if (firstTime) {
			firstTime = false;
			if(isFinished()){
				interrupted();
				return;
			}
		}
		run();
	}

	@Override
	public abstract void run();
}
