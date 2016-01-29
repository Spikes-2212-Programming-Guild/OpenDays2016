/**
 * 
 */
package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * @author User
 *
 */
public class SpeedControllersGroup implements SpeedController {

	private SpeedController[] speedControllers;
	
	public SpeedControllersGroup(SpeedController... speedControllers) {
		if(speedControllers == null || speedControllers.length == 0){
			throw new RuntimeException("argument error");
		}
		this.speedControllers = new SpeedController[speedControllers.length];
		System.arraycopy(speedControllers, 0,
						this.speedControllers,0,
						speedControllers.length);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.PIDOutput#pidWrite(double)
	 */
	@Override
	public void pidWrite(double output) {
		for(SpeedController sc: speedControllers){
			sc.pidWrite(output);
		}
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.SpeedController#get()
	 */
	@Override
	public double get() {
		return speedControllers[0].get();
	}

	/**
	 * @deprecated this method IS implemented, but we don't need to explicitly use it
	 * @see edu.wpi.first.wpilibj.SpeedController#set(double, byte)
	 */
	@Override
	@Deprecated
	public void set(double speed, byte syncGroup) {
		for(SpeedController sc: this.speedControllers){
			sc.set(speed, syncGroup);
		}
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.SpeedController#set(double)
	 */
	@Override
	public void set(double speed) {
		for(SpeedController sc: this.speedControllers){
			sc.set(speed);
		}
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.SpeedController#disable()
	 */
	@Override
	public void disable() {
		for(SpeedController sc: this.speedControllers){
			sc.disable();
		}
	}
}
