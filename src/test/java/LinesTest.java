import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @Test
    void getLinesTest() {
        int countOfPerson = 5;
        int ladderHeight = 20;
        Lines lines = new Lines(countOfPerson,ladderHeight);

        assertThat(lines.getLines().size())
                .isEqualTo(ladderHeight);

    }
}