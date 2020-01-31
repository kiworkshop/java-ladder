import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {

  @Test
  @DisplayName("왼쪽에서 사다리를 만나면 사다리를 타고 한칸 오른쪽으로 이동한다")
  public void move_assureMoveToRight() {
    // given
    Row row = Row.of(1, 4);
    List<LadderPoint> ladderPoints = new ArrayList<>();
    ladderPoints.add(LadderPoint.of(1,1));
    ladderPoints.add(LadderPoint.of(3,1));
    row.drawLadderLines(ladderPoints);
    // when
    int playerIndex1 = row.move(0);
    int playerIndex3 = row.move(2);
    // then
    assertThat(playerIndex1).isEqualTo(1);
    assertThat(playerIndex3).isEqualTo(3);
  }

  @Test
  @DisplayName("오른쪽에서 사다리를 만나면 사다리를 타고 한칸 왼쪽으로 이동한다")
  public void move_assureMoveToLeft() {
    // given
    Row row = Row.of(1, 4);
    List<LadderPoint> ladderPoints = new ArrayList<>();
    ladderPoints.add(LadderPoint.of(1,1));
    ladderPoints.add(LadderPoint.of(3,1));
    row.drawLadderLines(ladderPoints);
    // when
    int playerIndex1 = row.move(1);
    int playerIndex3 = row.move(3);
    // then
    assertThat(playerIndex1).isEqualTo(0);
    assertThat(playerIndex3).isEqualTo(2);
  }

  @Test
  @DisplayName("사다리가 없는 경우 동일한 인덱스를 반환한다")
  public void move_assureSameIndex() {
    // given
    Row row = Row.of(1, 4);
    List<LadderPoint> ladderPoints = new ArrayList<>();
    row.drawLadderLines(ladderPoints);
    // when
    int playerIndex1 = row.move(1);
    int playerIndex3 = row.move(3);
    // then
    assertThat(playerIndex1).isEqualTo(1);
    assertThat(playerIndex3).isEqualTo(3);
  }
}
