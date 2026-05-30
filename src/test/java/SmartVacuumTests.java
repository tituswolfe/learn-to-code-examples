import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import xyz.tituswolfe.robotics.solutions.SmartVacuumSolution;

import java.util.Random;

public class SmartVacuumTests {
    SmartVacuumSolution smartVacuum;
    final Random random = new Random();
    final int max = 40;
    final int min = 1;
    final int distanceThreshold = 20;

    @BeforeEach
    void setUp() {
        smartVacuum = new SmartVacuumSolution();
    }

    @Test
    public void testPickDirection_WhenRandomDistanceSensorInput() {
        assertTrue(testPickDirection(getRandomDistance(),  getRandomDistance(),  getRandomDistance()));
    }

    @Test
    public void testPickDirection_WhenFrontIsBlocked() {
        assertTrue(testPickDirection(15,  25,  25));
    }

    @Test
    public void testPickDirection_WhenLeftIsBlocked() {
        assertTrue(testPickDirection(25,  15,  27));
    }

    @Test
    public void testPickDirection_WhenRightIsBlocked() {
        assertTrue(testPickDirection(25,  25,  15));
    }

    @Test
    public void testPickDirection_WhenLeftAndRightIsBlocked() {
        assertTrue(testPickDirection(25,  15,  15));
    }

    @Test
    public void testPickDirection_WhenLeftAndFrontIsBlocked() {
        assertTrue(testPickDirection(15,  15,  25));
    }

    @Test
    public void testPickDirection_WhenFrontAndRightIsBlocked() {
        assertTrue(testPickDirection(15,  25,  15));
    }

    @Test
    public void testPickDirection_WhenAllDirectionsAreBlocked() {
        assertTrue(testPickDirection(25,  25,  25));
    }

    public boolean testPickDirection(int frontDistance, int leftDistance, int rightDistance) {
        boolean isFrontBlocked = frontDistance < distanceThreshold;
        boolean isLeftBlocked = leftDistance < distanceThreshold;
        boolean isRightBlocked = rightDistance < distanceThreshold;

        int direction = smartVacuum.pickDirection(frontDistance, leftDistance, rightDistance);

        boolean runIntoLeft = direction == 0 && isLeftBlocked;
        boolean runIntoFront = direction == 1 && isFrontBlocked;
        boolean runIntoRight = direction == 2 && isRightBlocked;
        boolean wasBackwardsTheOnlyOption = direction == 3 && isLeftBlocked && isFrontBlocked && isRightBlocked;

        return !runIntoRight && !runIntoFront && !runIntoLeft && !wasBackwardsTheOnlyOption;
    }

    public int getRandomDistance() {
        return random.nextInt(max - min + 1) + min;
    }
}
