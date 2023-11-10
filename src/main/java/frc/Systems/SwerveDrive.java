package frc.Systems;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class SwerveDrive extends SubsystemBase{
    public SwerveModule FrontLeft;
    public SwerveModule FrontRight;
    public SwerveModule BackLeft;
    public SwerveModule BackRight;
    public SwerveDrive(){
        FrontLeft = new SwerveModule(
            Constants.FrontLeftdriveMotorID,Constants.FrontLeftazimuthMotorID,Constants.FrontLeftcanCoderID);
        FrontRight = new SwerveModule(
            Constants.FrontRightdriveMotorID,Constants.FrontRightazimuthMotorID,Constants.FrontRightcanCoderID);
        BackLeft = new SwerveModule(
            Constants.BackLeftdriveMotorID,Constants.BackLeftazimuthMotorID,Constants.BackLeftcanCoderID);
        BackRight = new SwerveModule(
            Constants.BackRightdriveMotorID,Constants.BackRightazimuthMotorID,Constants.BackRightcanCoderID);
        WPI_PigeonIMU gyro = new WPI_PigeonIMU(Constants.GyroID);
        
    }
    public void SwerveMovement(double left_x, double left_y, double right_x) {
        if(left_x<Constants.deadzone){
            left_x=0;
        }
        if(left_y<Constants.deadzone){
            left_y=0;
        }
        if(right_x<Constants.deadzone){
            right_x=0;
        }
        vectorMath(left_x,left_y,right_x,135,FrontLeft);
        vectorMath(left_x,left_y,right_x,45,FrontRight);
        vectorMath(left_x,left_y,right_x,-135,BackLeft);
        vectorMath(left_x,left_y,right_x,-45,BackRight);
    }
    public void vectorMath(double left_x, double left_y, double right_x, double theta, SwerveModule module){
        double turnPowerX = right_x * Math.cos(theta);
        double turnPowerY = right_x * Math.sin(theta);

        double totalPowerX = turnPowerX + left_x;
        double totalPowerY = turnPowerY + left_y;

        double powerFinal = Math.sqrt(Math.pow(totalPowerX, 2) + Math.pow(totalPowerY, 2));
        double angleFinal = Math.tan(totalPowerY/totalPowerX);
        
        module.SetAngle(angleFinal);
        module.SetSpeed(powerFinal);
    }
}
