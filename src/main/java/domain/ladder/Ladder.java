package domain.ladder;

import domain.strategy.RowGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

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
}
