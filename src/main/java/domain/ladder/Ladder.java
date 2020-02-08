package domain.ladder;

import controller.dto.LadderInputDto;
import domain.factory.RowFactory;
import domain.result.LadderResult;
import domain.result.Result;
import domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {

    private List<User> users;
    private List<Row> rows = new ArrayList<>();
    private List<Result> results;

    public Ladder(LadderInputDto ladderInputDto, RowFactory rowFactory) {
        int numberOfSteps = ladderInputDto.getNumberOfSteps();
        for (int i = 0; i < ladderInputDto.getHeight(); i++) {
            rows.add(new Row(rowFactory.generateSteps(numberOfSteps)));
        }
        this.users = ladderInputDto.getUsers();
        this.results = ladderInputDto.getResults();
        if (this.users.size() != this.results.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Result getResultFrom(String userName) throws IllegalArgumentException {
        User targetUser = users.stream().filter(user -> user.getName().equals(userName)).findAny().orElseThrow(IllegalArgumentException::new);
        int targetIndex = users.indexOf(targetUser);
        int resultIndex = getResultIndexFrom(targetIndex);
        return results.get(resultIndex);
    }

    private int getResultIndexFrom(int index) {
        for (Row row : rows) {
            index = row.getNextIndexFrom(index);
        }
        return index;
    }

    public LadderResult getLadderResult() {
        Map<User, Result> ladderResult = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int resultIndex = getResultIndexFrom(i);
            Result result = results.get(resultIndex);
            ladderResult.put(user, result);
        }

        return new LadderResult(ladderResult);
    }

    @Override
    public String toString() {
        return getUsersString() + "\n" +
                getRowsString() +
                getResultsString();
    }

    private String getUsersString() {
        List<String> userNames = users.stream().map(User::getFormattedName).collect(Collectors.toList());
        return String.join(" ", userNames);
    }

    private String getResultsString() {
        List<String> resultList = results.stream().map(Result::getFormattedResult).collect(Collectors.toList());
        return String.join(" ", resultList);
    }

    public String getRowsString() {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(getRowString(row) + "\n");
        }
        return sb.toString();
    }

    private String getRowString(Row row) {
        List<Step> steps = row.getSteps();
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        for (Step step : steps) {
            sb.append(getStepString(step));
            sb.append("|");
        }
        return sb.toString();
    }

    private String getStepString(Step step) {
        if (step.exist()) {
            return "-----";
        }
        return "     ";
    }
}
