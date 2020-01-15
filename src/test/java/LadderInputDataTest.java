import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderInputDataTest {
  @Test
  void of_ValidInput_ValidOutput() {
    // given
    List<User> users = new ArrayList<>();
    users.add(User.with(UserName.of("김지우"),0));
    users.add(User.with(UserName.of("조광일"),1));
    LadderHeight height = LadderHeight.of(1);
    // when
    LadderInputData ladderInputData = LadderInputData.of(users, height);
    // then
    assertThat(ladderInputData.getUsers()).isEqualTo(users);
    assertThat(ladderInputData.getHeight()).isEqualTo(height);
  }
}
