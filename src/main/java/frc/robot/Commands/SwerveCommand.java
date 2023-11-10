package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Systems.SwerveDrive;

public class SwerveCommand extends CommandBase {
    private DoubleSupplier Left_x;
    private DoubleSupplier Left_y;
    private DoubleSupplier Right_x;
    private SwerveDrive robotSwerve;
    public SwerveCommand(SwerveDrive robotSwerve, DoubleSupplier Left_x, DoubleSupplier Left_y,DoubleSupplier Right_x){
        this.Left_x = Left_x;
        this.Left_y = Left_y;
        this.Right_x = Right_x;
        this.robotSwerve = robotSwerve;
        addRequirements(robotSwerve);
    }
    @Override
    public void execute(){
        robotSwerve.SwerveMovement(Left_x.getAsDouble(), Left_y.getAsDouble(), Right_x.getAsDouble());
    }
    
}
