package laddergame.domain.ladder;

import laddergame.domain.LadderGameInput;

import java.util.ArrayList;
import java.util.List;

public class LinesGenerator {

    private static List<Point> points = new ArrayList<>();
    private static List<LadderLine> ladderLines = new ArrayList<>();
    private static int numberOfLines;
    private static int numberOfRows;


    public static List<LadderLine> generateLines() {
        points = PointsGenerator.generatePoints();

        setNumberOfRows();
        setNumberOfLines();

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            List<LadderLine> row = generateRow(rowIndex);
            ladderLines.addAll(row);
        }

        return ladderLines;
    }

    private static void setNumberOfRows() {
        numberOfRows = LadderGameInput.getLadderHeight();
    }

    private static void setNumberOfLines() {
        int playerCount = 0; //Players.getPlayerCount();
        int numberOfLinesPerRow = playerCount - 1;
        numberOfLines = numberOfLinesPerRow * numberOfRows;
    }

    private static List<LadderLine> generateRow(int rowIndex) {
        List<LadderLine> row = new ArrayList<>();
        int numberOfLinesPerRow = numberOfLines / numberOfRows;
        int pointIndex = rowIndex * (numberOfLinesPerRow + 1);
        int lastIndexOfRow = pointIndex + numberOfLinesPerRow;

        while (pointIndex < lastIndexOfRow) {
            LadderLine ladderLine = new LadderLine(points.get(pointIndex), points.get(pointIndex + 1));
            row.add(ladderLine);
            pointIndex++;
        }

        return row;
    }

}
