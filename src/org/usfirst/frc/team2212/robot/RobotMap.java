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
		public static final class PortsCharger{
			public static final int LEFT = 8, RIGHT = 9, LIMIT = 0;
		}
		public static final class PortsGun{
			public static final int LEFT = 1, RIGHT = 2;
		}
	}
	
	public static final class SafetyReductionFactors { 
		public static double FACTOR_GUEST = 0.4,
				FACTOR_SUPERVISER = 0.8;
	}
	
	public static final class Speeds{
		public static final double CHARGE = 0.9, UNCHARGE = 0.9,
				SHOOT = 1;
	}
	
	public static final class Timeouts{
		public static final int SMALL_AMOUNT_OF_TIME = 1;
	}
}
