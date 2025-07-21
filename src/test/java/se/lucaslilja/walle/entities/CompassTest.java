package se.lucaslilja.walle.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @since 0.1.0
 */
class CompassTest {

    @Test
    void testCompassDirections() {
        Compass compass = new Compass(Compass.NORTH);
        compass.turnRight();
        assertEquals(Compass.EAST, compass.getCurrentDirection(), "Turning right from North should be East");
        compass.turnRight();
        assertEquals(Compass.SOUTH, compass.getCurrentDirection(), "Turning right from East should be South");
        compass.turnRight();
        assertEquals(Compass.WEST, compass.getCurrentDirection(), "Turning right from South should be West");
        compass.turnRight();
        assertEquals(Compass.NORTH, compass.getCurrentDirection(), "Turning right from West should be North");
        compass.turnLeft();
        assertEquals(Compass.WEST, compass.getCurrentDirection(), "Turning left from North should be West");
        compass.turnLeft();
        assertEquals(Compass.SOUTH, compass.getCurrentDirection(), "Turning left from West should be South");
        compass.turnLeft();
        assertEquals(Compass.EAST, compass.getCurrentDirection(), "Turning left from South should be East");
        compass.turnLeft();
        assertEquals(Compass.NORTH, compass.getCurrentDirection(), "Turning left from East should be North");
    }

    @Test
    void testCompassMovement() {
        Compass compass = new Compass(Compass.NORTH);
        assertEquals(0, compass.getCurrentDirection().getMovementX(), "North movement X should be 0");
        assertEquals(1, compass.getCurrentDirection().getMovementY(), "North movement Y should be 1");

        compass = new Compass(Compass.EAST);
        assertEquals(1, compass.getCurrentDirection().getMovementX(), "East movement X should be 1");
        assertEquals(0, compass.getCurrentDirection().getMovementY(), "East movement Y should be 0");

        compass = new Compass(Compass.SOUTH);
        assertEquals(0, compass.getCurrentDirection().getMovementX(), "South movement X should be 0");
        assertEquals(-1, compass.getCurrentDirection().getMovementY(), "South movement Y should be -1");

        compass = new Compass(Compass.WEST);
        assertEquals(-1, compass.getCurrentDirection().getMovementX(), "West movement X should be -1");
        assertEquals(0, compass.getCurrentDirection().getMovementY(), "West movement Y should be 0");
    }
}