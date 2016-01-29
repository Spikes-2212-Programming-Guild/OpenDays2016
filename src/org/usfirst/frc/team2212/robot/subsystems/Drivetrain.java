package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.commands.drive.Fwd;
import org.usfirst.frc.team2212.robot.other.SpeedControllersGroup;
import org.usfirst.frc.team2212.robot.other.StoppableSubsytem;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    SpeedControllersGroup left, right;
    
    public Drivetrain(SpeedControllersGroup left, SpeedControllersGroup right) {
		this.left = left;
		this.right = right;
	}

    /**
     * the parameter order in this constructor is 
     * not as random as random as it may seem:
     * when you tab & enter the parameters so that the last two will be
     * exactly below the first two, it looks the drivetrain from
     * bird's eye view
     */
    public Drivetrain(int frontLeft, int frontRight,
    					int rearLeft, int rearRight){
    	this(new SpeedControllersGroup(new VictorSP(frontLeft),
				new VictorSP(frontLeft)),
    	new SpeedControllersGroup(new VictorSP(frontRight),
				new VictorSP(frontRight)));
    }
    
    private void setLeftRight(double leftSp, double rightSp){
    	this.left.set(leftSp);
    	this.right.set(rightSp);
    }
    
    public void tank(double leftSp, double rightSp){
    	setLeftRight(leftSp, -rightSp);
    }
    
    public void fwd(double speed){
    	tank(speed, speed);
    }
    
    public void turn(double speed){
    	tank(speed, -speed);
    }

	public void stop() {
		tank(0, 0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Fwd());
	}
}

