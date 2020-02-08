package domain.ladder;

import domain.factory.RowFactory;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Row> rows = new ArrayList<>();

    public Ladder(int numberOfSteps, Height height, RowFactory rowFactory) {
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(rowFactory.generateSteps(numberOfSteps)));
        }
    }

    public int getResultIndexFrom(int index) {
        for (Row row : rows) {
            index = row.getNextIndexFrom(index);
        }
        return index;
    }

    @Override
    public String toString() {
        return getRowsString();
    }

    private String getRowsString() {
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
