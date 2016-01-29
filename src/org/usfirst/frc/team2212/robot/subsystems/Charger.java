package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.other.StoppableSubsytem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;

/**
*
*/
public class Charger extends StoppableSubsytem {
	private VictorSP left, right;
	private DigitalInput ballsDetector;

	public Charger(VictorSP left, VictorSP right, DigitalInput ballsDetector) {
		this.left = left;
		this.right = right;
		this.ballsDetector = ballsDetector;
	}

	public Charger(int leftPort, int rightPort, int ballsDetectorPort) {
		this(new VictorSP(leftPort), new VictorSP(rightPort),
				new DigitalInput(ballsDetectorPort));
	}

	public void charge(double speed) {
		left.set(speed);
		right.set(speed);
	}

	public void uncharge(double absSpeed) {
		charge(-absSpeed);
	}

	@Override
	public void stop() {
		charge(0);
	}

	public boolean isBallAtTop() {
		return !ballsDetector.get();
	}

}