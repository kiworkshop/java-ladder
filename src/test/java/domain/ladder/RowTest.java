package domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static domain.ladder.StepTest.getExistingStepFixture;
import static domain.ladder.StepTest.getNonExistingStepFixture;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RowTest {

    public static Row getExistingNonExistingRow() {
        List<Step> steps = new ArrayList<>();
        steps.add(getExistingStepFixture());
        steps.add(getNonExistingStepFixture());
        steps.add(getExistingStepFixture());
        steps.add(getNonExistingStepFixture());
        steps.add(getExistingStepFixture());
        steps.add(getNonExistingStepFixture());
        return new Row(steps);
    }

    @Test
    void testRowConstructor() {
        Row row = getExistingNonExistingRow();
        assertTrue(row.getNextIndexFrom(0) == 1);
        assertTrue(row.getNextIndexFrom(1) == 0);
        assertTrue(row.getNextIndexFrom(2) == 3);
    }
}
