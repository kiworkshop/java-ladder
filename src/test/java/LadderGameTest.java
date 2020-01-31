import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사다리게임 실행 후 결과 index가 사다리게임 규칙에 맞게 반환된다")
  public void run_assureRightResult() {
    // given
    List<Row> rows = new ArrayList<>();
    int numOfParticipants = 4;
    rows.add(Row.of(0, numOfParticipants));
    rows.add(Row.of(1, numOfParticipants));
    rows.add(Row.of(2, numOfParticipants));

    List<LadderPoint> ladderPoints = new ArrayList<>();
    ladderPoints.add(LadderPoint.of(1, 1));
    ladderPoints.add(LadderPoint.of(2, 2));
    ladderPoints.add(LadderPoint.of(3, 0));

    LadderGame ladderGame = LadderGame.of(rows, ladderPoints);

    assertThat(ladderGame.run(0)).isEqualTo(2);
    assertThat(ladderGame.run(1)).isEqualTo(0);
    assertThat(ladderGame.run(2)).isEqualTo(3);
    assertThat(ladderGame.run(3)).isEqualTo(1);
  }
}
