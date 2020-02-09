package service;

import domain.ladder.Height;
import domain.result.Result;
import domain.result.Results;
import domain.user.User;
import domain.user.Users;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderService {

    private static final String USER_NAME_INPUT_DELIMITER = ",";

    public Users makeUsers(String userNamesInput) {
        List<String> names = Arrays.asList(userNamesInput.split(USER_NAME_INPUT_DELIMITER));
        return new Users(names.stream().map(User::from).collect(Collectors.toList()));
    }

    public Results makeResults(String resultsInput) {
        List<String> results = Arrays.asList(resultsInput.split(USER_NAME_INPUT_DELIMITER));
        return new Results(results.stream().map(Result::from).collect(Collectors.toList()));
    }

    public void validates(Users users, Results results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Height makeHeight(String heightInput) {
        try {
            int height = Integer.parseInt(heightInput);
            return Height.from(height);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

}
