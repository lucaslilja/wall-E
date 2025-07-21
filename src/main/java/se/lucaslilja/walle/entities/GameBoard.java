package se.lucaslilja.walle.entities;

/**
 * @since 0.1.0
 */
public record GameBoard(int width, int height) {
    public boolean isPositionValid(Position position) {
        return position.x() >= 0 && position.x() < width &&
                position.y() >= 0 && position.y() < height;
    }
}
