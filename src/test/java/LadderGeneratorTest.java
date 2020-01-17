import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
  @Test
  void generateLadder_InputManualStrategy() {
    // given
    int numOfGenerableColumn = 3;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    Row RowWithEvenIndexLinesFixture = RowWithEvenIndexLinesGeneratorStrategyTest.getEvenIndexRowFixture(numOfGenerableColumn);
    // when
    Ladder ladder = ladderGenerator.generateLadder(numOfGenerableColumn, height);
    // then
    assertThat(ladder.getRows()).hasSize(height);
    assertThat(ladder.getRows()).contains(RowWithEvenIndexLinesFixture);
  }

  @Test
  void generateRows_InputManualStrategy() {
    // given
    int numOfGenerableColumn = 3;
    int numOfEvenIndexLines = numOfGenerableColumn / 2 + 1;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    // when
    List<Row> rows = ladderGenerator.generateRows(numOfGenerableColumn, height);
    // then
    assertThat(rows).hasSize(height);
    assertThat(rows.get(0).getLines()).hasSize(numOfEvenIndexLines);
  }
}
