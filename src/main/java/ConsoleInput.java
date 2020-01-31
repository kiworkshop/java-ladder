import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

  public static final int INITIAL_POSITION = 0;
  public static final String DELIMITER = ",";
  public static final String MESSAGE_INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
  public static final String MESSAGE_INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
  public static final String MESSAGE_INPUT_GAME_PRIZES = "사다리 상품을 입력해주세요.(상품들은 쉼표(,)로 구분됩니다.)";
  public static final String ERROR_INPUT_NOT_INTEGER = "정수를 입력하셔야 합니다.";

  public static Scanner sc = new Scanner(System.in);

  public static LadderGameInputData getLadderGameInputData() {
    List<User> users = createUsersFrom(getInputUserNames());
    LadderHeight height = createHeight();
    List<Prize> prizes = createPrizesFrom(getInputPrizeNames());
    return LadderGameInputData.of(users, height, prizes);
  }

  private static List<String> getInputPrizeNames() {
    System.out.println(MESSAGE_INPUT_GAME_PRIZES);
    return Arrays.asList(sc.nextLine().split(DELIMITER));
  }

  static List<Prize> createPrizesFrom(List<String> prizeNames) {
    List<Prize> prizes = new ArrayList<>();

    int position = INITIAL_POSITION;
    for (String prizeName: prizeNames) {
      Prize prize = Prize.with(prizeName, position);
      prizes.add(prize);
      position++;
    }
    return prizes;
  }

  private static List<String> getInputUserNames() {
    System.out.println(MESSAGE_INPUT_USER_NAMES);
    return Arrays.asList(sc.nextLine().split(DELIMITER));
  }

  static List<User> createUsersFrom(List<String> userNames) {
    List<User> users = new ArrayList<>();

    int position = INITIAL_POSITION;
    for (String userName: userNames) {
      User user = User.with(UserName.of(userName), position);
      users.add(user);
      position++;
    }
    return users;
  }

  private static LadderHeight createHeight() {
    System.out.println(MESSAGE_INPUT_MAX_LADDER_HEIGHT);
    return LadderHeight.of(getInputHeight());
  }

  private static int getInputHeight() {
    String height = sc.nextLine();
    if (isConvertibleIntoInteger(height)) {
     return Integer.parseInt(height);
    }
    throw new IllegalArgumentException(ERROR_INPUT_NOT_INTEGER);
  }

  public static boolean isConvertibleIntoInteger(String str) {
    for (char c: str.toCharArray()) {
      if (c < 48 || c > 57) {
        System.out.println(c);
        return false;
      }
    }
    return true;
  }
}
