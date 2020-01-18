import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getLinePositionsTest() {
        int countOfPerson = 5;
        Line line = new Line(countOfPerson);
        assertThat(line.getLinePositions().size())
                .isNotNegative()
                .isLessThan(countOfPerson);
    }
}