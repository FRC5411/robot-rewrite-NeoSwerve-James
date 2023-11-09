package frc.Systems;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import frc.robot.Constants;
public class SwerveDrive{
    public SwerveDrive(){
        SwerveModule FrontLeft = new SwerveModule(
            Constants.FrontLeftdriveMotorID,Constants.FrontLeftazimuthMotorID,Constants.FrontLeftcanCoderID);
        SwerveModule FrontRight = new SwerveModule(
            Constants.FrontRightdriveMotorID,Constants.FrontRightazimuthMotorID,Constants.FrontRightcanCoderID);
        SwerveModule BackLeft = new SwerveModule(
            Constants.BackLeftdriveMotorID,Constants.BackLeftazimuthMotorID,Constants.BackLeftcanCoderID);
        SwerveModule BackRight = new SwerveModule(
            Constants.BackRightdriveMotorID,Constants.BackRightazimuthMotorID,Constants.BackRightcanCoderID);
        WPI_PigeonIMU gyro = new WPI_PigeonIMU(Constants.GyroID);
        
    }


}
