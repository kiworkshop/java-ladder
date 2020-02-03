package domain.factory;

import domain.ladder.Step;

import java.util.List;

public interface RowFactory {

    public List<Step> generateSteps(int numberOfSteps);
}
