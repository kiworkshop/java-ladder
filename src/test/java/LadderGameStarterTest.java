import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LadderGameStarterTest {

  @Test
  public void ladder_point들은_가로로_겹치지_않는다() {
    // given
    LadderGameStarter ladderStarter = getGameStarterFixture();

    // when
    List<LadderPoint> ladderPoints = ladderStarter.generateLadderPoints();

    // then
    List<Integer> yList = ladderPoints.stream().map(ladderPoint -> ladderPoint.getY()).collect(Collectors.toList());
    Set<Integer> ySet = ladderPoints.stream().map(ladderPoint -> ladderPoint.getY()).collect(Collectors.toSet());
    assertThat(yList.size()).isEqualTo(ySet.size());
  }

  @Test
  public void arg값과_중복된_랜덤값을_생성하지_않는다() {
    LadderGameStarter ladderStarter = getGameStarterFixture();
    assertThat(ladderStarter.generateRandomNum(4, 4)).isNotEqualTo(4);
    assertThat(ladderStarter.generateRandomNum(4, 1)).isNotEqualTo(1);
    assertThat(ladderStarter.generateRandomNum(4, 2)).isNotEqualTo(2);
  }

  public LadderGameStarter getGameStarterFixture() {
    List<User> users = new ArrayList<>();
    users.add(User.of("myang1"));
    users.add(User.of("myang2"));
    users.add(User.of("myang3"));
    users.add(User.of("myang4"));
    int height = 5;
    UserInput userInput = new UserInput(users, height);
    return LadderGameStarter.from(userInput);
  }

}
