package game;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Result;
import domain.strategy.RandomRowGenerateStrategy;
import domain.strategy.RowGenerateStrategy;
import domain.user.User;
import game.data.LadderData;
import game.input.GameInputScanner;
import game.output.GameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final String USER_NAME_INPUT_DELIMITER = ",";
    private static final RowGenerateStrategy rowGenerateStrategy = new RandomRowGenerateStrategy();

    public void play() {
        LadderData ladderData = generateLadderData();
        Ladder ladder = generateLadder(ladderData);
        printResult(ladder);
    }

    private LadderData generateLadderData() {
        List<User> users = generateUsers();
        List<Result> results = generateResults();
        validateResult(users, results);
        Height height = generateHeight();
        return new LadderData(users, results, height);
    }

    private List<User> generateUsers() {
        String userNameInput = GameInputScanner.getUserNames();
        List<String> names = Arrays.asList(userNameInput.split(USER_NAME_INPUT_DELIMITER));
        return names.stream().map(User::from).collect(Collectors.toList());
    }

    private List<Result> generateResults() {
        String resultsInput = GameInputScanner.getResults();
        List<String> results = Arrays.asList(resultsInput.split(USER_NAME_INPUT_DELIMITER));
        return results.stream().map(Result::from).collect(Collectors.toList());
    }

    private void validateResult(List<User> users, List<Result> results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException();
        }
    }

    private Height generateHeight() {
        String heightInput = GameInputScanner.getHeight();
        try {
            int height = Integer.parseInt(heightInput);
            return Height.from(height);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private Ladder generateLadder(LadderData ladderData) {
        return new Ladder(ladderData, rowGenerateStrategy);
    }

    private void printResult(Ladder ladder) {
        GameOutputView.printLadder(ladder);
        LadderResult ladderResult = ladder.getLadderResult();
        GameOutputView.printLadderResult(ladderResult);
    }
}
