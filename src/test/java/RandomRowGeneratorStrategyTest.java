import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRowGeneratorStrategyTest {
  @Test
  void generateLines() {
    // given

    // when

    // then

  }

  @Test
  void getNonSequentialRandomLines() {
    // given
    RandomRowGeneratorStrategy randomRowGeneratorStrategy = new RandomRowGeneratorStrategy();
    int numOfLines = 3;
    // when
    List<Line> lines = randomRowGeneratorStrategy.generateNonSequentialRandomLines(numOfLines);
    // then
    assertThat(isNotSequential(lines)).isTrue();
  }

  private boolean isNotSequential(List<Line> lines) {
    int prevEndPosition = -1;
    for (Line line: lines) {
      if (line.getStartPosition() == prevEndPosition) {
        return false;
      }
      prevEndPosition = line.getEndPosition();
    }
    return true;
  }

  //  테스트에서만 쓰이는 코드를 위한 테스트
  @Test
  void isNotSequential_InputSequentialLines_CheckFalse() {
    // given
    List<Line> lines = new ArrayList<>();
    Line prevSequential = Line.startWith(0);
    Line nextSequential = Line.startWith(1);
    lines.add(prevSequential);
    lines.add(nextSequential);
    // then
    assertThat(isNotSequential(lines)).isFalse();
  }

  //  테스트에서만 쓰이는 코드를 위한 테스트
  @Test
  void isNotSequential_InputNotSequentialLines_CheckTrue() {
    // given
    List<Line> lines = new ArrayList<>();
    Line prevSequential = Line.startWith(0);
    Line nextSequential = Line.startWith(2);
    lines.add(prevSequential);
    lines.add(nextSequential);
    // then
    assertThat(isNotSequential(lines)).isTrue();
  }
}
