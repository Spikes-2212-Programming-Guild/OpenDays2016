package org.usfirst.frc.team2212.robot.commands.advanced;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameCommandSequential extends CommandGroup {
    
	public final Command command;
	public final int times;
	
    public  SameCommandSequential(Command command, int times) {
        this.command = command;
        this.times = times;
        for(int i = 0; i < times; i++){
        	addSequential(command);
        }
    }
}
