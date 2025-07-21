package se.lucaslilja.walle.logic;

import se.lucaslilja.walle.entities.*;

import java.util.Scanner;

/**
 * The GameController is responsible for taking user input and act on it to perform various game related tasks.
 *
 * @since 0.1.0
 */
public final class GameController {
    private final Scanner scanner = new Scanner(System.in);

    public GameBoard createGameBoard(String message) {
        System.out.println(message);
        String gameBoardData = scanner.nextLine().trim();
        try {
            return createGameBoardFromInput(gameBoardData);
        } catch (IllegalArgumentException e) {
            return createGameBoard(e.getMessage());
        }
    }

    static GameBoard createGameBoardFromInput(String input) {
        String[] dimensions = input.trim().split(" ");
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Invalid input. Please enter two integers separated by space.");
        }
        try {
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("Width and height must be positive integers.");
            }
            return new GameBoard(width, height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter two integers separated by space.");
        }
    }

    public Robot createRobot(GameBoard gameBoard, String message) {
        System.out.println(message);
        String robotData = scanner.nextLine().trim();
        try {
            Robot robot = createRobotFromInput(robotData);
            Position position = robot.getPosition();
            if (!gameBoard.isPositionValid(position)) {
                throw new IllegalArgumentException("Robot position [%d, %d] is out of bounds of the game board (%dx%d). Valid positions are [0..%d, 0..%d]."
                        .formatted(position.x(), position.y(),
                                gameBoard.width(), gameBoard.height(),
                                gameBoard.width() - 1, gameBoard.height() - 1));
            }
            return robot;
        } catch (IllegalArgumentException e) {
            return createRobot(gameBoard, e.getMessage());
        }
    }

    static Robot createRobotFromInput(String input) {
        String[] robotParameters = input.trim().split(" ");
        if (robotParameters.length != 3) {
            throw new IllegalArgumentException("Invalid input. Please enter two integers and direction (N, E, S or W) separated by space.");
        }
        try {
            int x = Integer.parseInt(robotParameters[0]);
            int y = Integer.parseInt(robotParameters[1]);
            if (x < 0 || y < 0) {
                throw new IllegalArgumentException("Position x and y must be non-negative integers.");
            }
            String dir = robotParameters[2].toUpperCase();
            Compass.Direction direction = switch (dir) {
                case "N" -> Compass.NORTH;
                case "E" -> Compass.EAST;
                case "S" -> Compass.SOUTH;
                case "W" -> Compass.WEST;
                default -> throw new IllegalArgumentException("Invalid direction %s. Use N, E, S or W.".formatted(dir));
            };
            return new Robot(new Position(x, y), direction);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter two integers and direction (N, E, S or W) separated by space.");
        }
    }

    public void startGame(Game game) {
        boolean isRunning = true;
        while (isRunning) {
            String command = scanner.nextLine().trim().toUpperCase();
            if ("EXIT".equals(command)) {
                System.out.println("Exiting the game, goodbye!");
                break;
            }
            try {
                game.executeCommand(command);
                System.out.println("Report: " + game.robot().getPositionAndDirection());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                isRunning = false;
            }
        }
    }
}
