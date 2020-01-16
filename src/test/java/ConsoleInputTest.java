import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleInputTest {
  public static List<User> getUsersFixture(String name) {
    return ConsoleInput.getUsers(Arrays.asList(name.split(",")));
  }

  @Test
  void getUsers_ValidInput_ValidOutput() {
    // given
    List<String> userNames = Arrays.asList("김지우,조광일".split(","));
    // when
    List<User> users = ConsoleInput.getUsers(userNames);
    // then
    assertThat(users).hasSize(2);
    assertThat(users.get(0).getUserName().getName()).isEqualTo("김지우");
    assertThat(users.get(0).getPosition()).isEqualTo(0);
    assertThat(users.get(1).getUserName().getName()).isEqualTo("조광일");
    assertThat(users.get(1).getPosition()).isEqualTo(1);
  }
}