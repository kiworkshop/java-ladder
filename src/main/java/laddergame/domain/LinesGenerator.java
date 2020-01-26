package laddergame.domain;

import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class LinesGenerator {

    private static List<Point> points = new ArrayList<>();
    private static List<Line> lines = new ArrayList<>();
    private static int numberOfLines;
    private static int numberOfRows;


    public static List<Line> generateLines() {
        points = PointsGenerator.generatePoints();

        setNumberOfRows();
        setNumberOfLines();

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            List<Line> row = generateRow(rowIndex);
            lines.addAll(row);
        }

        return lines;
    }

    private static void setNumberOfRows() {
        numberOfRows = LadderGameInput.getLadderHeight();
    }

    private static void setNumberOfLines() {
        int playerCount = Players.getPlayerCount();
        int numberOfLinesPerRow = playerCount - 1;
        numberOfLines = numberOfLinesPerRow * numberOfRows;
    }

    private static List<Line> generateRow(int rowIndex) {
        List<Line> row = new ArrayList<>();
        int numberOfLinesPerRow = numberOfLines / numberOfRows;
        int pointIndex = rowIndex * (numberOfLinesPerRow + 1);
        int lastIndexOfRow = pointIndex + numberOfLinesPerRow;

        while (pointIndex < lastIndexOfRow) {
            Line line = new Line(points.get(pointIndex), points.get(pointIndex + 1));
            row.add(line);
            pointIndex++;
        }

        return row;
    }

}
