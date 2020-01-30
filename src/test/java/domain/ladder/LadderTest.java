package domain.ladder;

import domain.strategy.ExistNonExistRowStrategy;
import domain.strategy.RowGenerateStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderTest {

    private static final int NUMBER_OF_USERS = 5;
    private static final int HEIGHT = 5;
    private static final RowGenerateStrategy rowGenerateStrategy = new ExistNonExistRowStrategy();

    @Test
    void testLadder() {
        Ladder ladder = new Ladder(NUMBER_OF_USERS, HEIGHT, rowGenerateStrategy);
        assertTrue(ladder.getResultFrom(0) == 1);
    }
}
