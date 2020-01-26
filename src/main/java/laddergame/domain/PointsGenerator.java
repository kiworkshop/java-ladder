package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PointsGenerator {

    private static int numberOfX;
    private static int numberOfY;

    public static List<Point> generatePoints() {
        setNumberOfPoints();
        ArrayList<Integer> xs = createXs();
        ArrayList<Integer> ys = createYs();

        return xs.stream()
                .flatMap(x -> ys.stream().map(y -> new Point(x, y)))
                .collect(Collectors.toList());
    }

    private static void setNumberOfPoints() {
        numberOfX = LadderGameInput.getLadderHeight();
        numberOfY = LadderGamePlayers.getPlayerCount();
    }

    public static ArrayList<Integer> createXs() {
        ArrayList<Integer> xs = new ArrayList<>();
        for (int x = 0; x < numberOfX; x++) {
            xs.add(x);
        }
        return xs;
    }

    public static ArrayList<Integer> createYs() {
        ArrayList<Integer> ys = new ArrayList<>();
        for (int y = 0; y < numberOfY; y++) {
            ys.add(y);
        }
        return ys;
    }

}
