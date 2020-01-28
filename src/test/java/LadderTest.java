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
    rows.add(RowTest.getRowFixtureWithLinesStartingWithEvenIndex(numOfLines));
    rows.add(RowTest.getRowFixtureWithLinesStartingWithEvenIndex(numOfLines));
    // when
    Ladder ladder = Ladder.with(rows);
    // then
    assertThat(ladder.getRows()).isEqualTo(rows);
  }
  
  @Test
  void startWith_InputInitialUserPosition_OutputSamePosition() {
    // given
    int lenOfRow = 3;
    List<Row> rows = new ArrayList<>();
    Row firstRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    Row secondRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    rows.add(firstRow);
    rows.add(secondRow);
    Ladder ladder = Ladder.with(rows);
    int initialUserPosition = 1;
    // when
    int finalPosition = ladder.startWith(initialUserPosition);
    // then
    assertThat(finalPosition).isEqualTo(initialUserPosition);
  }

  @Test
  void startWith_InputInitialUserPosition_OutputRightPosition() {
    // given
    int lenOfRow = 3;
    List<Row> rows = new ArrayList<>();
    Row firstRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    Row secondRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    Row thirdRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    rows.add(firstRow);
    rows.add(secondRow);
    rows.add(thirdRow);
    Ladder ladder = Ladder.with(rows);
    int initialUserPosition = 0;
    int rightPosition = initialUserPosition + 1;
    // when
    int finalPosition = ladder.startWith(initialUserPosition);
    // then
    assertThat(finalPosition).isEqualTo(rightPosition);
  }

  @Test
  void startWith_InputInitialUserPosition_OutputLeftPosition() {
    // given
    int lenOfRow = 3;
    List<Row> rows = new ArrayList<>();
    Row firstRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    Row secondRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    Row thirdRow = RowTest.getRowFixtureWithLinesStartingWithEvenIndex(lenOfRow);
    rows.add(firstRow);
    rows.add(secondRow);
    rows.add(thirdRow);
    Ladder ladder = Ladder.with(rows);
    int initialUserPosition = 1;
    int leftPosition = initialUserPosition - 1;
    // when
    int finalPosition = ladder.startWith(initialUserPosition);
    // then
    assertThat(finalPosition).isEqualTo(leftPosition);
  }
}
