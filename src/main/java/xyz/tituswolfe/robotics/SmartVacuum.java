package xyz.tituswolfe.robotics;

// - Scenario -
// You are programing a smart vacuum.
// The smart vacuum has three distance sensors, front, right, and left.
// The vacuum should detect an obstacle when it gets less than 20 units away.
// If the front is blocked, the vacuum should go either left or right, unless a direction is blocked by another obstacle.
// If all directions are blocked, the vacuum should turn around.

// Returns an int representing direction, starting at zero on the left, moving clockwise.
// Example:
// left = 0
// forward = 1
// right = 2
// backwards = 3;

public class SmartVacuum {
    final static int distanceThreshold = 20;

    public int pickDirection(int frontDistance, int leftDistance, int rightDistance) {
        boolean isFrontBlocked = frontDistance < distanceThreshold;
        boolean isLeftBlocked = leftDistance < distanceThreshold;
        boolean isRightBlocked = rightDistance < distanceThreshold;

        if (isFrontBlocked) {
            if (!isLeftBlocked) {
                return 0;
            } else if (!isRightBlocked) {
                return 2;
            } else {
                return 3;
            }
        }

        return 1;
    }
}
