import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
  @Test
  void with_ValidInput_ValidOutput() {
    // given
    List<User> users = ConsoleInputTest.getUsersFixture("김지우,조광일,구미향");
    LadderHeight height = LadderHeightTest.getLadderHeightFixture(3);
    LadderInputData ladderInputData = LadderInputData.of(users, height);
    RowGeneratorStrategy rowGeneratorStrategy = new RowWithEvenIndexLinesGeneratorStrategy();
    // when
    LadderGame ladderGame = LadderGame.with(ladderInputData, rowGeneratorStrategy);
    // then
    assertThat(ladderGame.getUsers()).isEqualTo(users);
    assertThat(ladderGame.getHeight()).isEqualTo(height);
    assertThat(ladderGame.getLadderGenerator().getRowGeneratorStrategy()).isEqualTo(rowGeneratorStrategy);
  }

  @Test
  void generateLadder_ManualStrategy_ValidLadder() {
    // given
    String names = "김지우,조광일,구미향";
    int numOfNames = 3;
    int height = 4;
    Row rowFixture = RowTest.getRowFixture(numOfNames);
    LadderInputData ladderInputData = LadderInputDataTest.getLadderInputDataFixture(names, height);
    RowGeneratorStrategy rowGeneratorStrategy = new RowWithEvenIndexLinesGeneratorStrategy();
    LadderGame ladderGame = LadderGame.with(ladderInputData, rowGeneratorStrategy);
    // when
    ladderGame.generateLadder();
    // then 테스트 코드들을 관통하는 Fixture
    assertThat(ladderGame.getLadder().getRows()).hasSize(height);
    assertThat(ladderGame.getLadder().getRows()).contains(rowFixture);
  }
}
