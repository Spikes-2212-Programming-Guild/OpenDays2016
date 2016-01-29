package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
	//I should probably add private constructors, too,
	//but I don't think anyone in this place is dumb enough to try
	//and invoke this class or any of the classes in this file
	public static final class Ports{
		public static final class PortsDrive{
			public static final int LEFT_FRONT = 1, RIGHT_FRONT = 2,
					LEFT_REAR = 3, RIGHT_REAR = 4;
		}
	}
	
	public static final class SAFETY_REDUCTION_FACTORS { 
		public static double FACTOR_GUEST = 0.4,
				FACTOR_SUPERVISER = 0.8;
	}
}
