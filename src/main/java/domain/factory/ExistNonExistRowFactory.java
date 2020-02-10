package domain.factory;

import domain.ladder.Step;

import java.util.ArrayList;
import java.util.List;

public class ExistNonExistRowFactory implements RowFactory {
    @Override
    public List<Step> generateSteps(int numberOfSteps) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < numberOfSteps; i++) {
            if (i % 2 == 0) {
                steps.add(Step.existingStep());
            }
            if (i % 2 == 1) {
                steps.add(Step.nonExistingStep());
            }
        }
        return steps;
    }
}
