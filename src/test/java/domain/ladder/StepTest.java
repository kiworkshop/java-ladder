package domain.ladder;

import domain.ladder.Step;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {

    public static Step getExistingStepFixture() {
        return Step.existingStep();
    }

    public static Step getNonExistingStepFixture() {
        return Step.nonExistingStep();
    }

    @Test
    void testStepConstructor() {
        Step nonExistingStep = Step.nonExistingStep();
        assertThat(nonExistingStep.exist()).isFalse();

        Step existingStep = Step.existingStep();
        assertThat(existingStep.exist()).isTrue();
    }
}
