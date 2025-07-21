package se.lucaslilja.walle.entities;

/**
 * The compass handles direction and what it means to move in a certain direction.
 * It is implemented as a circular double linked list of directions.
 *
 * @since 0.1.0
 */
public final class Compass {
    public static final Direction NORTH = new Direction('N', 0, 1);
    public static final Direction EAST = new Direction('E', 1, 0);
    public static final Direction SOUTH = new Direction('S', 0, -1);
    public static final Direction WEST = new Direction('W', -1, 0);

    private Direction currentDirection;

    public Compass(Direction currentDirection) {
        this.currentDirection = currentDirection;
        NORTH.setLeft(WEST);
        NORTH.setRight(EAST);
        EAST.setLeft(NORTH);
        EAST.setRight(SOUTH);
        SOUTH.setLeft(EAST);
        SOUTH.setRight(WEST);
        WEST.setLeft(SOUTH);
        WEST.setRight(NORTH);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnLeft() {
        currentDirection = currentDirection.getLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.getRight();
    }

    public static class Direction {
        private final char name;
        private final int movementX;
        private final int movementY;
        private Direction left;
        private Direction right;

        public Direction(char name, int movementX, int movementY) {
            this.name = name;
            this.movementX = movementX;
            this.movementY = movementY;
        }

        public char getName() {
            return name;
        }

        public int getMovementX() {
            return movementX;
        }

        public int getMovementY() {
            return movementY;
        }

        public Direction getLeft() {
            return left;
        }

        private void setLeft(Direction left) {
            this.left = left;
        }

        public Direction getRight() {
            return right;
        }

        private void setRight(Direction right) {
            this.right = right;
        }
    }
}
