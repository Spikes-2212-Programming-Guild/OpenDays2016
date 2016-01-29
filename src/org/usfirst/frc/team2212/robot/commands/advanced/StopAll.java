package org.usfirst.frc.team2212.robot.commands.advanced;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.drive.Break;
import org.usfirst.frc.team2212.robot.other.StoppableSubsytem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2212.robot.other.StoppableSubsytem.Stop;
/**
 *
 */
public class StopAll extends CommandGroup {   
    public  StopAll() {
       addParallel(new Stop(Robot.gun));
       addParallel(new Stop(Robot.charger));
       addParallel(new Break());
    }
}
