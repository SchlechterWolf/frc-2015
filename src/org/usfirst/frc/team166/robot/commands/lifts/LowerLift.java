package org.usfirst.frc.team166.robot.commands.lifts;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;
import org.usfirst.frc.team166.robot.subsystems.Lift;

/**
 *
 */
public class LowerLift extends Command {

	private Lift lift;

	public LowerLift(Lift m_lift) {
		requires(m_lift);
		lift = m_lift;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		lift.moveDown();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (Robot.rcLift.areLiftsInContact() && Robot.toteLift.isBoundaryHit()) || lift.isBoundaryHit();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lift.stop();
		lift.resetEncoder();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
