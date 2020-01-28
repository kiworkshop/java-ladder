import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
  public static Row getRowFixtureWithLinesStartingWithEvenIndex(int lenOfRow) {
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

  @Test
  void getNextPosition_GivenLeftLine_ThenLeftPosition() {
    // given
    int lenOfRow = 2;
    Row row = getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    int prevPosition = 1;
    int leftPosition = prevPosition - 1;
    // when
    int nextPosition = row.getNextPosition(prevPosition);
    // then
    assertThat(nextPosition).isEqualTo(leftPosition);
  }

  @Test
  void getNextPosition_GivenRightLine_ThenRightPosition() {
    // given
    int lenOfRow = 2;
    Row row = getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    int prevPosition = 0;
    int rightPosition = prevPosition + 1;
    // when
    int nextPosition = row.getNextPosition(prevPosition);
    // then
    assertThat(nextPosition).isEqualTo(rightPosition);
  }

  @Test
  void getNextPosition_GivenNoLine_ThenSamePosition() {
    // given
    int lenOfRow = 2;
    Row row = getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    int prevPosition = 2;
    // when
    int nextPosition = row.getNextPosition(prevPosition);
    // then
    assertThat(nextPosition).isEqualTo(prevPosition);
  }
}
