import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
  @Test
  void generateLadder_InputManualStrategy() {
    // given
    int numOfColumn = 3;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    Row RowWithEvenIndexLinesFixture = RowWithEvenIndexLinesGeneratorStrategyTest.getEvenIndexRowFixture(numOfColumn);
    // when
    Ladder ladder = ladderGenerator.generateLadder(numOfColumn, height);
    // then
    assertThat(ladder.getRows()).hasSize(height);
    assertThat(ladder.getRows()).contains(RowWithEvenIndexLinesFixture);
  }

  @Test
  void generateRows_InputManualStrategy() {
    // given
    int numOfColumn = 3;
    int numOfEvenIndexLines = numOfColumn / 2 + 1;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    // when
    List<Row> rows = ladderGenerator.generateRows(numOfColumn, height);
    // then
    assertThat(rows).hasSize(height);
    assertThat(rows.get(0).getLines()).hasSize(numOfEvenIndexLines);
  }
}
