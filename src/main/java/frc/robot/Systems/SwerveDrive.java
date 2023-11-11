import com.ctre.phoenix.sensors.Pigeon2;
import frc.robot.Systems.SwerveModule;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveDrive extends SubsystemBase{
    public SwerveModule frontLeft;
    public SwerveModule frontRight;
    public SwerveModule backLeft;
    public SwerveModule backRight;
    public Pigeon2 gyro;

    public SwerveDrive(){
        frontLeft = new SwerveModule(
            Constants.frontLeftDriveMotorID,Constants.frontLeftAzimuthMotorID,Constants.frontLeftCanCoderID);
        frontRight = new SwerveModule(
            Constants.frontRightDriveMotorID,Constants.frontRightAzimuthMotorID,Constants.frontRightCanCoderID);
        backLeft = new SwerveModule(
            Constants.backLeftDriveMotorID,Constants.backLeftAzimuthMotorID,Constants.backLeftCanCoderID);
        backRight = new SwerveModule(
            Constants.backRightDriveMotorID,Constants.backRightAzimuthMotorID,Constants.backRightCanCoderID);
        gyro = new Pigeon2(Constants.gyroID);
    }

    public void swerveMovement(double leftX, double leftY, double rightX) {
        if(leftX < Constants.deadzone) leftX = 0;
        if(leftY < Constants.deadzone) leftY = 0;
        if(rightX < Constants.deadzone) rightX = 0;

        vectorMath(leftX, leftY, rightX, 45, frontRight);
        vectorMath(leftX, leftY, rightX, -135, backLeft);
        vectorMath(leftX, leftY, rightX, -45, backRight);
        vectorMath(leftX, leftY, rightX, 135, frontLeft);
    }

    public void vectorMath(double leftX, double leftY, double rightX, double theta, SwerveModule module){
        double turnPowerX = rightX * Math.cos(theta);
        double turnPowerY = rightX * Math.sin(theta);

        double totalPowerX = turnPowerX + leftX;
        double totalPowerY = turnPowerY + leftY;

        double powerFinal = Math.sqrt(Math.pow(totalPowerX, 2) + Math.pow(totalPowerY, 2));
        double angleFinal = Math.tan(totalPowerY/totalPowerX);
        
        module.setAngle(angleFinal);
        module.setSpeed(powerFinal);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("FL Angle", frontLeft.lastAngle);
        SmartDashboard.putNumber("FR Angle", frontRight.lastAngle);
        SmartDashboard.putNumber("BL Angle", backLeft.lastAngle);
        SmartDashboard.putNumber("BR Angle", backRight.lastAngle);
    }
}
