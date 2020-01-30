package domain.strategy;

import domain.ladder.Step;

import java.util.List;

public interface RowGenerateStrategy {

    public List<Step> generateSteps(int numberOfSteps);
}
