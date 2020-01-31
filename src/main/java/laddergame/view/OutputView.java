package laddergame.view;

import laddergame.domain.player.Player;
import org.apache.commons.lang3.StringUtils;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderLine;
import laddergame.domain.ladder.Point;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static String MESSAGE_GAME_RESULT = "실행결과";

    public void printResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println();

        printPlayerNames(players);
        printLadder(ladder);
    }

    private void printPlayerNames(Players players) {
        String playerNames = getAlignedPlayerNames(players);

        System.out.println(playerNames);
    }

    private String getAlignedPlayerNames(Players players) {
        List<String> playerNames = new ArrayList<>();
        players.stream().forEach(player -> playerNames.add(player.getName()));

        String alignedPlayerNames ="";
        for (String playerName : playerNames) {
            String alignedPlayerName = getAlignedPlayerName(playerName);
            alignedPlayerNames += alignedPlayerName;
        }

        return alignedPlayerNames;
    }

    private String getAlignedPlayerName(String playerName) {
        return StringUtils.leftPad(playerName, Player.PLAYER_NAME_MAX_LENGTH + 1);
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
