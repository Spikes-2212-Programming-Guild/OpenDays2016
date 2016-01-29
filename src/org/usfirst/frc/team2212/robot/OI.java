package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2212.robot.commands.drive.Fwd;
import org.usfirst.frc.team2212.robot.commands.drive.Turn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {

	public final Joystick JS_GUEST = new Joystick(0),
			JS_SUPERVISER = new Joystick(1);

	public static enum Permission {
		PERMISSION_GUEST, PERMISSION_SUPERVISER;
		
		public double getSafetyReductionFactor(){
			return this == PERMISSION_GUEST ?
					RobotMap.SafetyReductionFactors.FACTOR_GUEST : 
					RobotMap.SafetyReductionFactors.FACTOR_SUPERVISER;
		}
	}

	private JoystickButton btnSuperviserBlockingAll, btnGuestTurn, btnSuperviserTurn;
	public OI() {
		btnSuperviserBlockingAll = new JoystickButton(JS_SUPERVISER, 1);
	
		btnGuestTurn = new JoystickButton(JS_GUEST, 5);
		btnGuestTurn.whileHeld(new Turn());
		
		btnSuperviserTurn = new JoystickButton(JS_SUPERVISER, 2);
		btnSuperviserTurn.whileActive(new Turn());
		
	}

	public boolean isSuperviserBlockingAll() {
		return btnSuperviserBlockingAll.get();
	}
	

	public Joystick getJoystickByPermission(Permission permission) {
		return permission == Permission.PERMISSION_GUEST ? JS_GUEST : JS_SUPERVISER;
	}

	public Joystick getJoystickByPermission() {
		return getJoystickByPermission(getCurrentPermission());
	}
	
	public Permission getCurrentPermission(){
		return isSuperviserBlockingAll() ?
				Permission.PERMISSION_SUPERVISER :
				Permission.PERMISSION_GUEST;
	}

	public double getMaxThrottle() {
		return Math.max(getSuperviserThrottle(), getGuestThrottle());
	}
	
	public double getLimitedThrottle(){
		return Math.min(getSuperviserThrottle(), getGuestThrottle());
	}
	
	public double getSuperviserThrottle(){
		return JS_SUPERVISER.getThrottle();
	}
	
	public double getGuestThrottle(){
		return JS_GUEST.getThrottle();
	}
}
