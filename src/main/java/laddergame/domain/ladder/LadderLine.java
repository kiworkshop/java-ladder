package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        this.points = points;
    }

    public static LadderLine with(final int width) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            Point point = generatePoint(width);
            points.add(point);
        }

        return new LadderLine(points);
    }

    private static Point generatePoint(int width) {
        if(isFirstPoint()) {
            return Point.generateFirstPoint();
        }

        if (isLastPoint(width)) {
            return Point.generateLastPoint();
        }

        return Point.generatePoint();
    }

    private static boolean isFirstPoint() {
        return points == null;
    }

    private static boolean isLastPoint(int width) {
        return points.size() == width;
    }
}
