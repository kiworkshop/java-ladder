package domain.ladder;

import controller.dto.LadderInputDto;
import domain.factory.ExistNonExistRowFactory;
import domain.factory.NonExistRowFactory;
import domain.factory.RowFactory;
import domain.result.LadderResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static controller.dto.LadderInputDtoTest.getLadderDataFixture;

public class LadderTest {

    private static final RowFactory EXIST_NON_EXIST_ROW_FACTORY = new ExistNonExistRowFactory();
    private static final RowFactory NON_EXIST_ROW_FACTORY = new NonExistRowFactory();

    private Ladder ladder;
    private Ladder noStepLadder;

    public static Ladder getLadderFixture() {
        LadderInputDto ladderInputDto = getLadderDataFixture();
        Ladder ladder = new Ladder(ladderInputDto, EXIST_NON_EXIST_ROW_FACTORY);
        return ladder;
    }

    public static Ladder getNoStepLadderFixtrue() {
        LadderInputDto ladderInputDto = getLadderDataFixture();
        Ladder ladder = new Ladder(ladderInputDto, NON_EXIST_ROW_FACTORY);
        return ladder;
    }

    @BeforeEach
    void setUp() {
        ladder = getLadderFixture();
        noStepLadder = getNoStepLadderFixtrue();
    }

    @Test
    void testLadder() {
        assertThat(ladder.getResultFrom("jaeju"));
    }

    @Test
    void testLadderResult() {
        LadderResult ladderResult = ladder.getLadderResult();
    }
}
