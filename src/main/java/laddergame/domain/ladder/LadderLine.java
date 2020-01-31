package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.LadderCreationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    public static final String POINT= "|";
    public static final String CONNECTION= "-----";
    public static final String NON_CONNECTION= "     ";

    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        this.points = points;
    }

    public static LadderLine with(final int width, LadderCreationStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point previousPoint = null;

        for (int i = 0; i < width; i++) {
            int remain = width - i;
            Point point = generatePoint(previousPoint, remain, strategy);
            points.add(point);
            previousPoint = point;
        }

        return new LadderLine(points);
    }

    private static Point generatePoint(Point point, int remain, LadderCreationStrategy strategy) {
        if (isFirstPoint(point)) {
            return Point.generateFirstPoint(strategy);
        }

        if (isLastPoint(remain)) {
            return Point.generateLastPoint(point);
        }

        return point.decideNextPoint(strategy);
    }

    private static boolean isFirstPoint(Point point) {
        return point == null;
    }

    private static boolean isLastPoint(int remain) {
        return remain == 1;
    }

    public int size() {
        return points.size();
    }

    public String lineToString() {
        List<Point> points = getPoints();

        String result = "     ";
        for (Point point : points) {
            String connectionString = point.connectionToString();
            result += (POINT + connectionString);
        }
        return result;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
