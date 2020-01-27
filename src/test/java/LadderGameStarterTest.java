import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameStarterTest {

  @Test
  @DisplayName("사다리는 가로로 두번이상 연속 되지 않는다")
  public void generateLadderPoint_notSubsequentLadder() {
    // given
    LadderGameStarter ladderStarter = getGameStarterFixture();

    // when
    List<LadderPoint> ladderPoints = ladderStarter.generateLadderPoints();

    // then
    for (LadderPoint ladderPoint : ladderPoints) {
      assertThat(twoLaddersContinuous(ladderPoint, ladderPoints)).isFalse();
    }
  }

  private boolean twoLaddersContinuous(LadderPoint ladderPoint, List<LadderPoint> ladderPoints) {
    return ladderPoints.contains(LadderPoint.of(ladderPoint.getX(), ladderPoint.getY() - 1)) &&
        ladderPoints.contains(LadderPoint.of(ladderPoint.getX(), ladderPoint.getY() + 1));
  }

  @Test
  public void arg값과_중복된_랜덤값을_생성하지_않는다() {
    LadderGameStarter ladderStarter = getGameStarterFixture();
    assertThat(ladderStarter.generateRandomNum(4, Collections.singletonList(4))).isNotEqualTo(4);
    assertThat(ladderStarter.generateRandomNum(4, Collections.singletonList(1))).isNotEqualTo(1);
    assertThat(ladderStarter.generateRandomNum(4, Collections.singletonList(2))).isNotEqualTo(2);
  }

  public LadderGameStarter getGameStarterFixture() {
    List<User> users = new ArrayList<>();
    users.add(User.of("name1"));
    users.add(User.of("name2"));
    users.add(User.of("name3"));
    users.add(User.of("name4"));
    int height = 5;
    UserInput userInput = new UserInput(users, height);
    return LadderGameStarter.from(userInput);
  }

}
