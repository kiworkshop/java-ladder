import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleInputTest {
  public static List<User> getUsersFixture(String userName) {
    return ConsoleInput.createUsersFrom(Arrays.asList(userName.split(",")));
  }

  public static List<Prize> getPrizesFixture(String prizeName) {
    return ConsoleInput.createPrizesFrom(Arrays.asList(prizeName.split(",")));
  }

  @Test
  void createUsers_ValidInput_ValidOutput() {
    // given
    List<String> userNames = Arrays.asList("김지우,조광일".split(","));
    // when
    List<User> users = ConsoleInput.createUsersFrom(userNames);
    // then
    assertThat(users).hasSize(2);
    assertThat(users.get(0).getUserName().getName()).isEqualTo("김지우");
    assertThat(users.get(0).getPosition()).isEqualTo(0);
    assertThat(users.get(1).getUserName().getName()).isEqualTo("조광일");
    assertThat(users.get(1).getPosition()).isEqualTo(1);
  }

  @Test
  void createPrizes_ValidInput_ValidOutput() {
    // given
    List<String> prizeNames = Arrays.asList("꽝,3000".split(","));
    // when
    List<Prize> prizes = ConsoleInput.createPrizesFrom(prizeNames);
    // then
    assertThat(prizes).hasSize(2);
    assertThat(prizes.get(0).getPrizeName()).isEqualTo("꽝");
    assertThat(prizes.get(0).getPosition()).isEqualTo(0);
    assertThat(prizes.get(1).getPrizeName()).isEqualTo("3000");
    assertThat(prizes.get(1).getPosition()).isEqualTo(1);
  }
  
  @Test
  void isConvertibleIntoInteger_InputInteger_ReturnTrue() {
    // given
    String str = "7";
    // then
    assertThat(ConsoleInput.isConvertibleIntoInteger(str)).isTrue();
  }

  @Test
  void isConvertibleIntoInteger_InputNotInteger_ReturnFalse() {
    // given
    String str = "notConvertible";
    // then
    assertThat(ConsoleInput.isConvertibleIntoInteger(str)).isFalse();
  }
}