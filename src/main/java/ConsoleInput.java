import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

  public static final int INITIAL_POSITION = 0;
  public static final String DELIMITER = ",";
  public static final String MESSAGE_INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
  public static final String MESSAGE_INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  public static Scanner sc = new Scanner(System.in);

  public static LadderInputData getLadderData() {
    List<User> users = getUsers(getInputUserNames());
    LadderHeight height = getHeight();
    return LadderInputData.of(users, height);
  }

  static List<User> getUsers(List<String> userNames) {
    List<User> users = new ArrayList<>();

    int position = INITIAL_POSITION;
    for (String userName: userNames) {
      User user = User.with(UserName.of(userName), position);
      users.add(user);
      position++;
    }
    return users;
  }

  private static List<String> getInputUserNames() {
    System.out.println(MESSAGE_INPUT_USER_NAMES);
    return Arrays.asList(sc.nextLine().split(DELIMITER));
  }

  private static LadderHeight getHeight() {
    System.out.println(MESSAGE_INPUT_MAX_LADDER_HEIGHT);
    return LadderHeight.of(getInputHeight());
  }

  private static int getInputHeight() {
    return sc.nextInt();
  }
}
