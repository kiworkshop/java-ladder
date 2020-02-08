package controller;

import domain.factory.RandomRowFactory;
import domain.factory.RowFactory;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.Result;
import domain.result.Results;
import domain.user.User;
import domain.user.Users;
import view.input.GameInputScanner;
import view.output.GameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private static final String USER_NAME_INPUT_DELIMITER = ",";
    private static final RowFactory ROW_FACTORY = new RandomRowFactory();

    public void play() {
        Users users = generateUsers();
        Results results = generateResults();
        validate(users, results);
        Height height = generateHeight();
        Ladder ladder = new Ladder(users.size() - 1, height, ROW_FACTORY);
        printLadder(users, ladder, results);
        showResult(users, ladder, results);
    }

    private Users generateUsers() {
        String userNameInput = GameInputScanner.getUserNames();
        List<String> names = Arrays.asList(userNameInput.split(USER_NAME_INPUT_DELIMITER));
        return new Users(names.stream().map(User::from).collect(Collectors.toList()));
    }

    private Results generateResults() {
        String resultsInput = GameInputScanner.getResults();
        List<String> results = Arrays.asList(resultsInput.split(USER_NAME_INPUT_DELIMITER));
        return new Results(results.stream().map(Result::from).collect(Collectors.toList()));
    }

    private void validate(Users users, Results results) {
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

    private void printLadder(Users users, Ladder ladder, Results results) {
        GameOutputView.printUsers(users);
        GameOutputView.printLadder(ladder);
        GameOutputView.printResults(results);
    }

    private void showResult(Users users, Ladder ladder, Results results) {
        while (true) {
            String userName = GameInputScanner.getUserNameForResult();
            if ("all".equals(userName)) {
                break;
            }
            int index = users.findIndexBy(userName);
            int resultIndex = ladder.getResultIndexFrom(index);
            Result result = results.get(resultIndex);
            GameOutputView.printResult(result);
        }
    }

}
