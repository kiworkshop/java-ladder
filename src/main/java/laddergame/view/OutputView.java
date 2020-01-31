package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderLine;
import laddergame.domain.ladder.Point;
import laddergame.domain.player.Players;

import java.util.List;

public class OutputView {

    private static String MESSAGE_GAME_RESULT = "실행결과";

    public void printResult(Players players, Ladder ladder) {
        printResultMessage();

        printPlayerNames(players);

        printLadder(ladder);
    }

    private void printResultMessage() {
        System.out.println();
        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println();
    }

    private void printPlayerNames(Players players) {
        String playerNames = players.getAlignedPlayerNames();

        System.out.println(playerNames);
    }

    private void printLadder(Ladder ladder) {
        List<LadderLine> lines = ladder.getLines();

        for (LadderLine line : lines) {
            printLadderLine(line);
        }
    }

    private void printLadderLine(LadderLine line) {
        String lineString = lineToString(line);

        System.out.println(lineString);
    }

    private String lineToString(LadderLine line) {
        List<Point> points = line.getPoints();
        String result = "     ";

        for (Point point : points) {
            String connectionString = connectionToString(point);
            result += ("|" + connectionString);
        }

        return result;
    }

    private String connectionToString(Point point) {
        if (point.hasRightConnection()) {
            return "-----";
        }
        return "     ";
    }
}
