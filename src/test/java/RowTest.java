import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
  public static Row getRowFixture(int numOfLines) {
    return Row.of(RowWithEvenIndexLinesGeneratorStrategyTest.getEvenIndexLinesFixture(numOfLines));
  }

  @Test
  void of_ValidInput_ValidOutput() {
    // given
    List<Line> lines = new ArrayList<>();
    lines.add(Line.startWith(0));
    lines.add(Line.startWith(2));
    // when
    Row row = Row.of(lines);
    // then
    assertThat(row.getLines()).isEqualTo(lines);
  }
}
