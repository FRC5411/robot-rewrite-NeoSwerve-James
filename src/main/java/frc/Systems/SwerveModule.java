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
    public SwerveModule(int DriveMotorID, int AzimuthMotorID, int AngleEncoderID){
        DriveMotor = new CANSparkMax(DriveMotorID, MotorType.kBrushless);
        AzimuthMotor = new CANSparkMax(AzimuthMotorID, MotorType.kBrushless);
        AngleEncoder = new CANCoder(AngleEncoderID);
        azimuthEncoder = AzimuthMotor.getEncoder();
    }

    public void SetSpeed(){
        
    }
    public void SetAngle(double setpoint){
        angleController = new PIDController(0.02, 0.001, 0.0);
        AzimuthMotor.set(angleController.calculate(AngleEncoder.getPosition(), setpoint));
    }

}