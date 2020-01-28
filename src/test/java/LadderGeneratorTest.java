import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
  @Test
  void generateLadder_InputManualStrategy() {
    // given
    int numOfUsers = 3;
    int lenOfRow = numOfUsers - 1;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    Row RowWithEvenIndexLinesFixture = RowWithEvenIndexLinesGeneratorStrategyTest.getEvenIndexRowFixture(lenOfRow);
    // when
    Ladder ladder = ladderGenerator.generateLadder(numOfUsers, height);
    // then
    assertThat(ladder.getRows()).hasSize(height);
    assertThat(ladder.getRows()).contains(RowWithEvenIndexLinesFixture);
  }

  @Test
  void generateRows_InputManualStrategy() {
    // given
    int numOfUsers = 3;
    int numOfEvenIndexLines = numOfUsers / 2;
    int height = 4;
    LadderGenerator ladderGenerator = LadderGenerator.with(new RowWithEvenIndexLinesGeneratorStrategy());
    // when
    List<Row> rows = ladderGenerator.generateRows(numOfUsers, height);
    // then
    assertThat(rows).hasSize(height);
    assertThat(rows.get(0).getLines()).hasSize(numOfEvenIndexLines);
  }
}
