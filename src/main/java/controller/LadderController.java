package controller;

import controller.dto.LadderInputDto;
import domain.factory.RandomRowFactory;
import domain.factory.RowFactory;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Result;
import domain.user.User;
import view.input.GameInputScanner;
import view.output.GameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private static final String USER_NAME_INPUT_DELIMITER = ",";
    private static final RowFactory ROW_FACTORY = new RandomRowFactory();

    public void play() {
        LadderInputDto ladderInputDto = generateLadderData();
        Ladder ladder = new Ladder(ladderInputDto, ROW_FACTORY);
        GameOutputView.printLadder(ladder);
        showResult(ladder);
    }

    private LadderInputDto generateLadderData() {
        List<User> users = generateUsers();
        List<Result> results = generateResults();
        Height height = generateHeight();
        return new LadderInputDto(users, results, height);
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

    private Height generateHeight() {
        String heightInput = GameInputScanner.getHeight();
        try {
            int height = Integer.parseInt(heightInput);
            return Height.from(height);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private void showResult(Ladder ladder) {
        while (true) {
            String userName = GameInputScanner.getUserNameForResult();
            if ("all".equals(userName)) {
                break;
            }
            Result result = ladder.getResultFrom(userName);
            GameOutputView.printResult(result);
        }
        LadderResult ladderResult = ladder.getLadderResult();
        GameOutputView.printLadderResult(ladderResult);
    }

}
