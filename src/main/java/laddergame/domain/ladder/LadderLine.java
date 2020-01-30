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

        for (int i = 0; i < width; i++) {
            Point point = generatePoint(width, strategy);
            points.add(point);
        }

        return new LadderLine(points);
    }

    private static Point generatePoint(int width, LadderCreationStrategy strategy) {
        if(isFirstPoint()) {
            return Point.generateFirstPoint(strategy);
        }

        if (isLastPoint(width)) {
            return Point.generateLastPoint(strategy);
        }

        return Point.generatePoint(strategy);
    }

    private static boolean isFirstPoint() {
        return points == null;
    }

    private static boolean isLastPoint(int width) {
        return points.size() == width;
    }
}
