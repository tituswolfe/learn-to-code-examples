import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import xyz.tituswolfe.robotics.SmartVacuum;

import java.util.Random;

public class SmartVacuumTest {
    final Random random = new Random();
    final int max = 40;
    final int min = 1;
    final int distanceThreshold = 20;

    @Test
    public void testSmartVacuum() {
        SmartVacuum smartVacuum = new SmartVacuum();

        int frontDistance = getRandomDistance();
        int leftDistance = getRandomDistance();
        int rightDistance = getRandomDistance();

        boolean isFrontBlocked = frontDistance < distanceThreshold;
        boolean isLeftBlocked = leftDistance < distanceThreshold;
        boolean isRightBlocked = rightDistance < distanceThreshold;

        int direction = smartVacuum.pickDirection(frontDistance, leftDistance, rightDistance);

        assertFalse(direction == 0 && isLeftBlocked);
        assertFalse(direction == 1 && isFrontBlocked);
        assertFalse(direction == 2 && isRightBlocked);
        assertFalse(direction == 3 && !isLeftBlocked && !isFrontBlocked && !isRightBlocked);
    }

    public int getRandomDistance() {
        return random.nextInt(max - min + 1) + min;
    }
    
}
