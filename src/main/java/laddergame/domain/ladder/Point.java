package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LadderCreationStrategy;

public enum Point {

    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false);

    private boolean leftConnection;
    private boolean rightConnection;

    Point(boolean leftConnection, boolean rightConnection) {
        this.leftConnection = leftConnection;
        this.rightConnection = rightConnection;
    }

    public static Point generateFirstPoint(LadderCreationStrategy strategy) {
        return generatePoint(false, strategy.isConnectable());
    }

    public static Point generateLastPoint(Point point) {
        if (point.hasRightConnection()) {
            return generatePoint(true, false);
        }
        return generatePoint(false, false);
    }

    public Point decideNextPoint(LadderCreationStrategy strategy) {
        if (rightConnection) {
            return generatePoint(true, false );
        }
        return generatePoint(false, strategy.isConnectable());
    }

    private static Point generatePoint(boolean leftConnection, boolean rightConnection) {
        if (leftConnection && rightConnection) {
            throw new IllegalArgumentException();
        }

        if (leftConnection) {
            return LEFT;
        }

        if (rightConnection) {
            return RIGHT;
        }

        return NONE;
    }

    public boolean hasRightConnection() {
        return rightConnection;
    }

    public String connectionToString() {
        if (hasRightConnection()) {
            return LadderLine.CONNECTION;
        }
        return LadderLine.NON_CONNECTION;
    }
}
