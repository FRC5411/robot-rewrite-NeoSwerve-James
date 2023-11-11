package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
        public static final int gyroID = 1;
        public static final int frontLeftDriveMotorID = 11;
        public static final int frontLeftAzimuthMotorID = 21;
        public static final int frontLeftCanCoderID = 31;
        public static final Rotation2d frontLeftAngleOffset = Rotation2d.fromDegrees(40.166016);
    
        public static final int frontRightDriveMotorID = 12;
        public static final int frontRightAzimuthMotorID = 22;
        public static final int frontRightCanCoderID = 32;
        public static final Rotation2d frontRightAngleOffset = Rotation2d.fromDegrees(114.257812);

        public static final int backLeftDriveMotorID = 13;
        public static final int backLeftAzimuthMotorID = 23;
        public static final int backLeftCanCoderID = 33;
        public static final Rotation2d backLeftAngleOffset = Rotation2d.fromDegrees(302.695312);

        public static final int backRightDriveMotorID = 14;
        public static final int backRightAzimuthMotorID = 24;
        public static final int backRightCanCoderID = 34;
        public static final Rotation2d backRightAngleOffset = Rotation2d.fromDegrees(358.154297);

        public static final double deadzone = 0.05;
      
}
