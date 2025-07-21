package se.lucaslilja.walle.entities;

/**
 * Currently the game consists of a game board and a robot.
 *
 * @since 0.1.0
 */
public record Game(GameBoard gameBoard, Robot robot) {
    public void executeCommand(String command) {
        command = command.trim().toUpperCase();
        command.chars().forEach(c -> {
            switch (c) {
                case 'F' -> moveRobotForward();
                case 'L' -> robot.turnLeft();
                case 'R' -> robot.turnRight();
                default ->
                        throw new IllegalArgumentException("Invalid command encountered: %s. Skipping command".formatted(c));
            }
        });
    }

    private void moveRobotForward() {
        Position newPosition = robot.moveForward();
        if (!gameBoard.isPositionValid(newPosition)) {
            throw new IllegalArgumentException("Robot cannot move forward to position [%d, %d]. It is out of bounds of the game board (%dx%d). Valid positions are [0..%d, 0..%d]."
                    .formatted(newPosition.x(), newPosition.y(),
                            gameBoard.width(), gameBoard.height(),
                            gameBoard.width() - 1, gameBoard.height() - 1));
        }
    }
}
