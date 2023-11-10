package frc.Systems;
import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;

public class SwerveModule{
    public static CANSparkMax DriveMotor;
    public static CANSparkMax AzimuthMotor;
    public static CANCoder AngleEncoder;
    public static RelativeEncoder azimuthEncoder;
    public static PIDController angleController;
    public boolean isReversed;
    public SwerveModule(int DriveMotorID, int AzimuthMotorID, int AngleEncoderID){
        DriveMotor = new CANSparkMax(DriveMotorID, MotorType.kBrushless);
        AzimuthMotor = new CANSparkMax(AzimuthMotorID, MotorType.kBrushless);
        angleController = new PIDController(0.02, 0.001, 0.0);
        AngleEncoder = new CANCoder(AngleEncoderID);
        angleController.setTolerance(1);
        azimuthEncoder = AzimuthMotor.getEncoder();
        isReversed = false;
    }

    public void SetSpeed(double speed){
        if(isReversed){
            DriveMotor.set(-speed);
        }
        DriveMotor.set(speed);
    }
    public void SetAngle(double setpoint){
        double currentAngle = AngleEncoder.getAbsolutePosition();
        double setpointAngle = closestAngle(currentAngle, setpoint);
        if(Math.abs(setpointAngle) > 90) {
            setpointAngle -= (Math.signum(setpointAngle) * 180);
            isReversed = true;
        }
        angleController.setSetpoint(currentAngle+setpointAngle);
        AzimuthMotor.set(angleController.calculate(currentAngle));
    }
    public double closestAngle(double currentAngle, double setpoint){
        double dir = (setpoint%360.0) - (currentAngle%360.0);
        if(Math.abs(dir)>180.0){
            dir = -(Math.signum(dir)*360.0)+ dir;
        }
        return dir;
    }
}