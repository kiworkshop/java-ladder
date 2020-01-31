import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
  @Test
  void with_ValidInput_ValidOutput() {
    // given
    UserName name = UserName.of("김지우");
    int position = 1;
    // when
    User user = User.with(name, position);
    // then
    assertThat(user.getUserName()).isEqualTo(name);
    assertThat(user.getPosition()).isEqualTo(position);
  }

  @Test
  void hasUserName_SameName_ReturnTrue() {
    // given
    User user = User.with(UserName.of("same"), 0);
    UserName userName = UserName.of("same");
    // then
    assertThat(user.hasUserName(userName)).isTrue();
  }

  @Test
  void hasUserName_DifferentName_ReturnFalse() {
    // given
    User user = User.with(UserName.of("Diff"), 0);
    UserName userName = UserName.of("diff");
    // then
    assertThat(user.hasUserName(userName)).isFalse();
  }
}
