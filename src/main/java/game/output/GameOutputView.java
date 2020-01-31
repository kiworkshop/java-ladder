package game.output;

import domain.ladder.Ladder;
import domain.ladder.Row;
import domain.ladder.Step;
import domain.result.LadderResult;
import domain.result.Result;
import domain.user.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameOutputView {

    public static void printUsers(List<User> users) {
        List<String> userNames = users.stream().map(User::getFormattedName).collect(Collectors.toList());
        String usersOnLadder = String.join(" ", userNames);
        System.out.println(usersOnLadder);

    }

    public static void printResults(List<Result> results) {
        List<String> resultList = results.stream().map(Result::getFormattedResult).collect(Collectors.toList());
        String resultsUnderLadder = String.join(" ", resultList);
        System.out.println(resultsUnderLadder);
    }

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.println(ladderResult);
    }

    public static void printLadder(Ladder ladder) {
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            printRow(row);
        }
    }

    private static void printRow(Row row) {
        List<Step> steps = row.getSteps();
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        for (Step step : steps) {
            if (step.exist()) {
                sb.append("-----");
            } else {
                sb.append("     ");
            }
            sb.append("|");
        }
        System.out.println(sb.toString());
    }
}
