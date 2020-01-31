package domain.ladder;

import domain.result.LadderResult;
import domain.result.Result;
import domain.strategy.RowGenerateStrategy;
import domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private List<Row> rows = new ArrayList<>();

    public Ladder(int numberOfUsers, int height, RowGenerateStrategy rowGenerateStrategy) {
        int numberOfSteps = numberOfUsers - 1;
        for (int i = 0; i < height; i++) {
            rows.add(new Row(rowGenerateStrategy.generateSteps(numberOfSteps)));
        }
    }

    public int getResultFrom(int index) {
        for (Row row : rows) {
            index = row.getNextIndexFrom(index);
        }
        return index;
    }

    public LadderResult getLadderResult(List<User> users, List<Result> results) {
        Map<User, Result> ladderResult = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int resultIndex = getResultFrom(i);
            Result result = results.get(resultIndex);
            ladderResult.put(user, result);
        }

        return new LadderResult(ladderResult);
    }

    public List<Row> getRows() {
        return rows;
    }
}
