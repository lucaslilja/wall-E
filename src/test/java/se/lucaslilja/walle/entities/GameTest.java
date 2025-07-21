package se.lucaslilja.walle.entities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @since 0.1.0
 */
class GameTest {

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "F",
            "L",
            "R",
            "f",
            "l",
            "r",
            "RFRFFRFRF",
            ""
    })
    void testExecutingValidCommand(String command) {
        Game game = new Game(new GameBoard(10, 10), new Robot(new Position(5, 5), Compass.NORTH));
        assertDoesNotThrow(() -> game.executeCommand(command), "Executing valid command should not throw an exception");
    }

    @ParameterizedTest(name = "#{index} - code tested={0}")
    @ValueSource(strings = {
            "Fs",
            "d",
            "e",
            "-",
            "EXIT",
            "F L R",
            "FFFFFFF"
    })
    void testExecutingInvalidCommand(String command) {
        Game game = new Game(new GameBoard(10, 10), new Robot(new Position(5, 5), Compass.NORTH));
        assertThrows(IllegalArgumentException.class, () -> game.executeCommand(command), "Executing an invalid command should throw an exception");
    }
}