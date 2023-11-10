package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
        public static final int GyroID = 1;
        public static final int FrontLeftdriveMotorID = 11;
        public static final int FrontLeftazimuthMotorID = 21;
        public static final int FrontLeftcanCoderID = 31;
        public static final Rotation2d FrontLeftangleOffset = Rotation2d.fromDegrees(40.166016);
    
        public static final int FrontRightdriveMotorID = 12;
        public static final int FrontRightazimuthMotorID = 22;
        public static final int FrontRightcanCoderID = 32;
        public static final Rotation2d FrontRightangleOffset = Rotation2d.fromDegrees(114.257812);

        public static final int BackLeftdriveMotorID = 13;
        public static final int BackLeftazimuthMotorID = 23;
        public static final int BackLeftcanCoderID = 33;
        public static final Rotation2d BackLeftangleOffset = Rotation2d.fromDegrees(302.695312);

        public static final int BackRightdriveMotorID = 14;
        public static final int BackRightazimuthMotorID = 24;
        public static final int BackRightcanCoderID = 34;
        public static final Rotation2d BackRightangleOffset = Rotation2d.fromDegrees(358.154297);

        public static final double deadzone = 0.05;
      
}
