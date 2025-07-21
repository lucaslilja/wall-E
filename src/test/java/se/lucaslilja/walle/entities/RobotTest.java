package se.lucaslilja.walle.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.lucaslilja.walle.entities.Compass.NORTH;

/**
 * @since 0.1.0
 */
class RobotTest {

    @Test
    void testRobotInitialization() {
        Position initialPosition = new Position(0, 0);
        Robot robot = new Robot(initialPosition, NORTH);

        assertEquals("0 0 N", robot.getPositionAndDirection());
    }

    @Test
    void testRobotMovement() {
        Position initialPosition = new Position(0, 0);
        Robot robot = new Robot(initialPosition, NORTH);
        robot.moveForward();
        assertEquals("0 1 N", robot.getPositionAndDirection());
        robot.turnRight();
        robot.moveForward();
        assertEquals("1 1 E", robot.getPositionAndDirection());
    }
}