package game;

import domain.factory.RandomRowFactory;
import domain.factory.RowFactory;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Result;
import domain.user.User;
import game.dto.LadderInputDto;
import view.input.GameInputScanner;
import view.output.GameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final String USER_NAME_INPUT_DELIMITER = ",";
    private static final RowFactory ROW_FACTORY = new RandomRowFactory();

    public void play() {
        LadderInputDto ladderInputDto = generateLadderData();
        Ladder ladder = generateLadder(ladderInputDto);
        GameOutputView.printLadder(ladder);
        showResult(ladder);
    }

    private LadderInputDto generateLadderData() {
        List<User> users = generateUsers();
        List<Result> results = generateResults();
        validateResult(users, results);
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

    private Ladder generateLadder(LadderInputDto ladderInputDto) {
        return new Ladder(ladderInputDto, ROW_FACTORY);
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
