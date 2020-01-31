package game;

import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Result;
import domain.strategy.RandomRowGenerateStrategy;
import domain.strategy.RowGenerateStrategy;
import domain.user.User;
import game.input.GameInputScanner;
import game.output.GameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final String USER_NAME_INPUT_DELIMITER = ",";
    private static final RowGenerateStrategy rowGenerateStrategy = new RandomRowGenerateStrategy();

    public void play() {
        List<User> users = generateUsers();
        List<Result> results = generateResults();
        validateResult(users, results);
        int height = generateHeight();
        Ladder ladder = generateLadder(users, height);
        printResult(users, ladder, results);
    }

    private List<User> generateUsers() {
        String userNameInput = GameInputScanner.getUserNames();
        List<String> names = Arrays.asList(userNameInput.split(USER_NAME_INPUT_DELIMITER));
        return names.stream().map(User::new).collect(Collectors.toList());
    }

    private List<Result> generateResults() {
        String resultsInput = GameInputScanner.getResults();
        List<String> results = Arrays.asList(resultsInput.split(USER_NAME_INPUT_DELIMITER));
        return results.stream().map(Result::new).collect(Collectors.toList());
    }

    private void validateResult(List<User> users, List<Result> results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException();
        }
    }

    private int generateHeight() {
        String heightInput = GameInputScanner.getHeight();
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private Ladder generateLadder(List<User> users, int height) {
        return new Ladder(users.size(), height, rowGenerateStrategy);
    }

    private void printResult(List<User> users, Ladder ladder, List<Result> results) {
        GameOutputView.printUsers(users);
        GameOutputView.printLadder(ladder);
        GameOutputView.printResults(results);
        LadderResult ladderResult = ladder.getLadderResult(users, results);
        GameOutputView.printLadderResult(ladderResult);
    }
}
