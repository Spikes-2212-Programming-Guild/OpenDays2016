package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.other.StoppableSubsytem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class Gun extends StoppableSubsytem {

	private CANTalon left, right;

	public Gun(CANTalon left, CANTalon right) {
		this.left = left;
		this.right = right;
		this.left.changeControlMode(ControlMode.PercentVbus);
		this.right.changeControlMode(ControlMode.PercentVbus);
	}

	public Gun(int leftMotorID, int rightMotorID) {
		this(new CANTalon(leftMotorID), new CANTalon(rightMotorID));
	}

	public void shoot(double leftVoltage, double rightVoltage) {
		left.set(leftVoltage);
		right.set(-rightVoltage);
	}

	@Override
	public void stop() {
		left.set(0);
		right.set(0);
	}
}
