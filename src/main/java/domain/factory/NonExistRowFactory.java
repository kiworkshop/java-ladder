package domain.factory;

import domain.ladder.Step;

import java.util.ArrayList;
import java.util.List;

public class NonExistRowFactory implements RowFactory {
    @Override
    public List<Step> generateSteps(int numberOfSteps) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < numberOfSteps; i++) {
            steps.add(Step.nonExistingStep());
        }
        return steps;
    }
}
