import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNameTest {
  @Test
  void of_ValidInput_ValidOutput() {
    // given
    String name = "김지우";
    // when
    UserName userName = UserName.of(name);
    // then
    assertThat(userName.getName()).isEqualTo(name);
  }

  @Test
  void of_InvalidInput_InvalidOutput() {
    // given
    String name = "이름길이초과";
    // then
    assertThatThrownBy(() -> UserName.of(name)).isInstanceOf(IllegalArgumentException.class);
  }
}
