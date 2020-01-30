package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.LadderCreationStrategy;

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

    }

    public static Point generateLastPoint(LadderCreationStrategy strategy) {

    }

    public static Point generatePoint(LadderCreationStrategy strategy) {

    }
}
