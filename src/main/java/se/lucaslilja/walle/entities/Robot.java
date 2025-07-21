package se.lucaslilja.walle.entities;

/**
 * The robot has a position and a compass (which will represent it's direction in the game).
 *
 * @since 0.1.0
 */
public final class Robot {
    private final Compass compass;
    private Position position;

    public Robot(Compass.Direction startingDirection, Position startingPosition) {
        this.compass = new Compass(startingDirection);
        this.position = startingPosition;
    }

    public String getPosition() {
        return "%d %d %s".formatted(
                position.x(),
                position.y(),
                compass.getCurrentDirection().getName()
        );
    }

    public Position moveForward() {
        int newX = position.x() + compass.getCurrentDirection().getMovementX();
        int newY = position.y() + compass.getCurrentDirection().getMovementY();

        position = new Position(newX, newY);
        return position;
    }

    public void turnLeft() {
        compass.turnLeft();
    }

    public void turnRight() {
        compass.turnRight();
    }
}
