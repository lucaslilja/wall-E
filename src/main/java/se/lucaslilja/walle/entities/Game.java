package se.lucaslilja.walle.entities;

/**
 * Currently the game consists of a game board and a robot.
 *
 * @since 0.1.0
 */
public record Game(GameBoard gameBoard, Robot robot) {
}
