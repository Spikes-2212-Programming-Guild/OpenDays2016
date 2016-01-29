package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class TwoLimitSystem extends StoppableSubsytem {
	public interface ValueFunction {
		public double get();
	}

	private SpeedController sc;
	private DigitalInput up, down;
	@Override
	public void stop() {
		sc.set(0);
	}
	
	public boolean isUp(){
		return up.get();
	}

	public boolean isDown(){
		return down.get();
	}
	
	public enum Direction{
		Up, Down;
		public double signum(){
			switch(this){
			case Down:
				return -1;
			case Up:
				return 1;
			default:
				return 0;
				//TODO: discuss whether this should be NaN, 0,
				//or throw runtime exception
			}
		}
	}
	
	public boolean is(Direction dir){
		switch(dir){
		case Down:
			return isDown();
		case Up:
			return isUp();
		default:
			return false;
		}
	}
	
	public Command createCommand(Direction dir,
			ValueFunction speedAbsoluteValue){
		return new NonDumbCommand() {
			
			@Override
			protected boolean isFinished() {
				return TwoLimitSystem.this.is(dir);
			}
			
			@Override
			protected void interrupted() {
				end();
			}
			
			@Override
			protected void initialize() {
				
			}
			
			@Override
			protected void end() {
				TwoLimitSystem.this.stop();
			}

			@Override
			public void run() {
				TwoLimitSystem.this.
					sc.set(dir.signum() * speedAbsoluteValue.get());
			}
		};
	}
	
	public Command createCommand(Direction dir,
			double speedAbsoluteValue){
		return createCommand(dir, () -> speedAbsoluteValue);
	}
}
