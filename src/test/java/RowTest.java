import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
  public static Row getRowFixture(int lenOfRow) {
    return Row.of(lenOfRow, RowWithEvenIndexLinesGeneratorStrategyTest.getEvenIndexLinesFixture(lenOfRow));
  }

  @Test
  void of_ValidInput_ValidOutput() {
    // given
    List<Line> lines = new ArrayList<>();
    lines.add(Line.startWith(0));
    lines.add(Line.startWith(2));
    int lenOfRow = 3;
    // when
    Row row = Row.of(lenOfRow, lines);
    // then
    assertThat(row.getLines()).isEqualTo(lines);
    assertThat(row.getLenOfRow()).isEqualTo(lenOfRow);
  }
}
