import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
  @Test
  void with_ValidInput_ValidOutput() {
    // given
    List<Row> rows = new ArrayList<>();
    int numOfLines = 3;
    rows.add(RowTest.getRowFixture(numOfLines));
    rows.add(RowTest.getRowFixture(numOfLines));
    // when
    Ladder ladder = Ladder.with(rows);
    // then
    assertThat(ladder.getRows()).isEqualTo(rows);
  }
}
