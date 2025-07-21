package se.lucaslilja.walle.entities;

/**
 * The robot has a position and a compass (which will represent it's direction in the game).
 *
 * @since 0.1.0
 */
public final class Robot {
    private Position position;
    private final Compass compass;

    public Robot(Position startingPosition, Compass.Direction startingDirection) {
        this.position = startingPosition;
        this.compass = new Compass(startingDirection);
    }

    public String getPositionAndDirection() {
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

    public Position getPosition() {
        return position;
    }
}
