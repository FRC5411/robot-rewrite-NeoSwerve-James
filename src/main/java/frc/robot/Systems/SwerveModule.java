
import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;

public class SwerveModule{
    public static CANSparkMax driveMotor;
    public static CANSparkMax azimuthMotor;
    public static CANCoder angleEncoder;
    public static RelativeEncoder azimuthEncoder;
    public static PIDController angleController;
    public boolean isReversed;
    public double lastAngle;

    public SwerveModule(int driveMotorID, int azimuthMotorID, int angleEncoderID){
        driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
        azimuthMotor = new CANSparkMax(azimuthMotorID, MotorType.kBrushless);
        angleEncoder = new CANCoder(angleEncoderID);
        angleController = new PIDController(0.02, 0.001, 0.0);

        azimuthEncoder = azimuthMotor.getEncoder();
        
        angleController.setTolerance(1);
        isReversed = false;
    }

    public void setSpeed(double speed){
        if(isReversed) driveMotor.set(-speed);
        else driveMotor.set(speed);
    }
    public void setAngle(double setpoint){
        double currentAngle = angleEncoder.getAbsolutePosition();
        double setpointAngle = closestAngle(currentAngle, setpoint);
        if(Math.abs(setpointAngle) > 90) {
            setpointAngle -= (Math.signum(setpointAngle) * 180);
            isReversed = true;
        }
        angleController.setSetpoint(currentAngle + setpointAngle);
        azimuthMotor.set(angleController.calculate(currentAngle));
        lastAngle = setpointAngle;
    }
    public double closestAngle(double currentAngle, double setpoint){
        double dir = (setpoint % 360.0) - (currentAngle % 360.0);
        if(Math.abs(dir) > 180.0) dir = -(Math.signum(dir) * 360.0) + dir;
        
        return dir;
    }

    @Override
    public void periodic(){
    }
}