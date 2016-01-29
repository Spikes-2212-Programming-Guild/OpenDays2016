package org.usfirst.frc.team2212.robot.commands.advanced;

import org.usfirst.frc.spikes2212.robot.commands.charger.ChargeALittle;
import org.usfirst.frc.spikes2212.robot.commands.charger.ChargeOneBall;
import org.usfirst.frc.spikes2212.robot.commands.gun.JoystickStartGun;
import org.usfirst.frc.spikes2212.robot.commands.gun.StartGun;
import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ChargeAndShoot extends CommandGroup {
    public  ChargeAndShoot() {
    	addParallel(new JoystickStartGun());
    	addParallel(new ChargeOneBall());
    	addSequential(new WaitCommand(RobotMap.Timeouts.TIMEOUT_GUNSTART_TO_CHARGE));
    	addSequential(new ChargeALittle());
    }
}