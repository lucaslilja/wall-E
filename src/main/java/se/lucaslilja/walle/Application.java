package se.lucaslilja.walle;

import se.lucaslilja.walle.entities.Game;
import se.lucaslilja.walle.entities.GameBoard;
import se.lucaslilja.walle.entities.Robot;
import se.lucaslilja.walle.logic.GameController;

/**
 * @since 0.1.0
 */
public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        GameBoard gameBoard = gameController.createGameBoard("Enter the width and the height of the game board, separated by space:");
        System.out.printf("Game board created with dimensions: [%d, %d]%n", gameBoard.width(), gameBoard.height());
        System.out.println("You can now create a robot on the game board.");
        Robot robot = gameController.createRobot(gameBoard, "Enter the robot's initial position and direction by enter two integers and a character (N, E, S or W), e.g. '1 2 N':");
        Game game = new Game(gameBoard, robot);
        System.out.println("You can now start giving commands to the robot.");
        System.out.println("Enter commands for the robot (F, L, R) or type 'exit' to quit:");
        gameController.startGame(game);
    }
}
