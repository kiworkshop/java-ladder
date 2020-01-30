package laddergame.domain.ladder;

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

    public static Point generateFirstPoint() {

    }

    public static Point generateLastPoint() {

    }

    public static Point generatePoint() {

    }
}
