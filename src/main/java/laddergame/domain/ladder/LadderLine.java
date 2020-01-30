package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.LadderCreationStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

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
            return Point.generateLastPoint(strategy);
        }

        return point.decideNextPoint(strategy);
    }

    private static boolean isFirstPoint(Point point) {
        return point == null;
    }

    private static boolean isLastPoint(int remain) {
        return remain == 1;
    }
}
