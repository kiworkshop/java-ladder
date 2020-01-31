package game;

import domain.ladder.Ladder;
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
        int height = generateHeight();
        Ladder ladder = generateLadder(users, height);
        GameOutputView.printUsers(users);
        GameOutputView.printLadder(ladder);
    }

    private List<User> generateUsers() {
        String userNameInput = GameInputScanner.getUserNames();
        return getUsersFrom(userNameInput);
    }

    private List<User> getUsersFrom(String userNameInput) {
        List<String> names = Arrays.asList(userNameInput.split(USER_NAME_INPUT_DELIMITER));
        return names.stream().map(User::new).collect(Collectors.toList());
    }

    private int generateHeight() {
        String heightInput = GameInputScanner.getHeight();
        return getHeightFrom(heightInput);
    }

    private int getHeightFrom(String heightInput) {
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private Ladder generateLadder(List<User> users, int height) {
        return new Ladder(users.size(), height, rowGenerateStrategy);
    }

}
