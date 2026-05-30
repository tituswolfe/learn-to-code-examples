package xyz.tituswolfe.robotics.solutions;

// Challenge: Calculate the individual wheel speeds for a mecanum drivetrain.

// INPUT: Left joystick x and y,

// OUTPUT: double[4] { frontLeft, frontRight, backLeft, backRight }

public class MecanumDrivetrainJoystickControlSolution {

    public double[] calculateMecanumSpeeds(double x1, double y1, double x2, double y2) {
        double frontLeft = x1 + y1 + x2;
        double frontRight = x1 - y1 - x2;
        double backLeft = x1 - y1 + x2;
        double backRight = x1 + y1 - x2;

        return new double[] { frontLeft, frontRight, backLeft, backRight };
    }
}
