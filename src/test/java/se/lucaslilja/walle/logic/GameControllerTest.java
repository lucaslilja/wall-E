package se.lucaslilja.walle.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.lucaslilja.walle.entities.GameBoard;
import se.lucaslilja.walle.entities.Robot;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @since 0.1.0
 */
class GameControllerTest {

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "15 25",
            " 5 5 ",
            "1 1 ",
            "100 100"
    })
    void testCreateGameBoardFromValidInput(String input) {
        GameBoard gameBoard = GameController.createGameBoardFromInput(input);
        assertNotNull(gameBoard, "Game board should not be null");
        assertTrue(gameBoard.width() > 0, "Game board width should be positive");
        assertTrue(gameBoard.height() > 0, "Game board height should be positive");
    }

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "-15 25",
            "5  5",
            "1",
            "100 -100",
            "3 3 3",
            "abc def",
    })
    void testCreateGameBoardFromInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> GameController.createGameBoardFromInput(input));
    }

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "15 25 N",
            " 5 5 E ",
            "1 1 S ",
            "100 100 W"
    })
    void testCreateRobotFromValidInput(String input) {
        Robot robot = GameController.createRobotFromInput(input);
        assertNotNull(robot, "Robot should not be null");
        assertTrue(robot.getPosition().x() >= 0, "Robot position x should be non-negative");
        assertTrue(robot.getPosition().y() >= 0, "Robot position y should be non-negative");
    }

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "15 -25 N",
            " 5 5 EN ",
            "1  1 S ",
            "100 100 W X"
    })
    void testCreateRobotFromInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> GameController.createRobotFromInput(input));
    }
}