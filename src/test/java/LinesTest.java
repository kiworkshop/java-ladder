import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void getLinesTest() {
        int countOfPerson = 5;
        int ladderHeight = 20;
        Ladder ladder = new Ladder(countOfPerson,ladderHeight);

        assertThat(ladder.getLadder().size())
                .isEqualTo(ladderHeight);

    }
}