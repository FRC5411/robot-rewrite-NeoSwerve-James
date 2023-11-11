package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Systems.SwerveDrive;

public class SwerveCommand extends CommandBase {
    private DoubleSupplier leftX;
    private DoubleSupplier leftY;
    private DoubleSupplier rightX;
    private SwerveDrive robotSwerve;

    public SwerveCommand(SwerveDrive robotSwerve, DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightX){
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.robotSwerve = robotSwerve;
        addRequirements(robotSwerve);
    }

    @Override
    public void execute(){
        robotSwerve.swerveMovement(leftX.getAsDouble(), leftY.getAsDouble(), rightX.getAsDouble());
    }
}
