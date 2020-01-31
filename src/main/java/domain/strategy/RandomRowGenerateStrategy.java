package domain.strategy;

import domain.ladder.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowGenerateStrategy implements RowGenerateStrategy {

    private static final Random random = new Random();

    @Override
    public List<Step> generateSteps(int numberOfSteps) {
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i < numberOfSteps; i++) {
            if (i == 0) {
                steps.add(generateRandomStep());
            } else {
                if (!steps.get(i - 1).exist()) {
                    steps.add(generateRandomStep());
                } else {
                    steps.add(generateNonExistingStep());
                }
            }
        }

        return steps;
    }

    private Step generateRandomStep() {
        if (random.nextBoolean()) {
            return Step.existingStep();
        }
        return generateNonExistingStep();
    }

    private Step generateNonExistingStep() {
        return Step.nonExistingStep();
    }
}
