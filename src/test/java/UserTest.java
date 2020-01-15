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
}
