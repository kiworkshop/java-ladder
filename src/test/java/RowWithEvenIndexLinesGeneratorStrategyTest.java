import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowWithEvenIndexLinesGeneratorStrategyTest {
  public static Row getEvenIndexRowFixture(int lenOfRow) {
    return Row.of(lenOfRow, getEvenIndexLinesFixture(lenOfRow));
  }

  public static List<Line> getEvenIndexLinesFixture(int numOfLines) {
    List<Line> lines = new ArrayList<>();
    for (int i=0; i<numOfLines; i++) {
      if (i % 2 == 0) {
        Line line = Line.startWith(i);
        lines.add(line);
      }
    }
    return lines;
  }

  @Test
  void generateLines_InputLineNums_OutputManualLines() {
    // given
    RowWithEvenIndexLinesGeneratorStrategy rowWithEvenIndexLinesGeneratorStrategy = new RowWithEvenIndexLinesGeneratorStrategy();
    int numOfLines = 3;
    int numOfEvenIndexLines = 3 / 2 + 1;
    // when
    List<Line> lines = rowWithEvenIndexLinesGeneratorStrategy.generateLines(numOfLines);
    // then
    assertThat(lines).hasSize(numOfEvenIndexLines);
    assertThat(lines).contains(Line.startWith(0)).contains(Line.startWith(2));
  }
}
