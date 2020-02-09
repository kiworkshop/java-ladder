package domain.ladder;

import domain.factory.ExistNonExistRowFactory;
import domain.factory.NonExistRowFactory;
import domain.factory.RowFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.ladder.HeightTest.getFiveLevelOfHeightFixture;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private static final RowFactory EXIST_NON_EXIST_ROW_FACTORY = new ExistNonExistRowFactory();
    private static final RowFactory NON_EXIST_ROW_FACTORY = new NonExistRowFactory();

    private Ladder ladder;
    private Ladder noStepLadder;

    public static Ladder getLadderFixture() {
        Height height = getFiveLevelOfHeightFixture();
        return new Ladder(3, height, EXIST_NON_EXIST_ROW_FACTORY);
    }

    public static Ladder getNoStepLadderFixtrue() {
        Height height = getFiveLevelOfHeightFixture();
        return new Ladder(3, height, NON_EXIST_ROW_FACTORY);
    }

    @BeforeEach
    void setUp() {
        ladder = getLadderFixture();
        noStepLadder = getNoStepLadderFixtrue();
    }

    @Test
    void testLadder() {
        assertThat(ladder.getResultIndexFrom(0)).isEqualTo(1);
    }

    @Test
    void testNoStepLadder() {
        assertThat(noStepLadder.getResultIndexFrom(0)).isEqualTo(0);
    }
}
