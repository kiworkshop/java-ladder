import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleOutput {

  public static final String MESSAGE_LADDER_GAME_RESULT = "사다리 결과";
  public static final String NULL = "\0";
  public static final String BLANK_BETWEEN_NAMES = "  ";
  public static final String NEXT_LINE = "\n";
  public static final String INITIAL_STRING = "";
  public static final String BAR = "|";
  public static final String LEFT_MARGIN = "   ";
  public static final String BLANK = " ";
  private static final int MAXIMUM_LENGTH = 5;
  public static final String DELIMITER = " : ";
  public static final String ALL = "all";
  public static final String MESSAGE_NOT_PARTICIPANT = "참가한 유저가 아닙니다.";
  public static final String MESSAGE_WANT_TO_KNOW = "결과를 보고 싶은 사람은?";

  public static Scanner sc = new Scanner(System.in);

  public static void showLadderGameResultWith(LadderGameOutputData ladderGameOutputData) {
    showLadderGame(ladderGameOutputData.getUsers(), ladderGameOutputData.getLadder(), ladderGameOutputData.getPrizes());
    showGameResult(ladderGameOutputData.getLadderResult());
  }

  private static void showLadderGame(List<User> users, Ladder ladder, List<Prize> prizes) {
    System.out.println(MESSAGE_LADDER_GAME_RESULT);
    showUsers(users);
    showLadder(ladder);
    showPrizes(prizes);
  }

  private static void showUsers(List<User> users) {
    users.forEach(user -> showNameToMaximumLength(user.getUserName().getName()));
    System.out.print(NEXT_LINE);
  }

  private static void showPrizes(List<Prize> prizes) {
   prizes.forEach(prize -> showNameToMaximumLength(prize.getPrizeName()));
   System.out.print(NEXT_LINE);
  }

  private static void showNameToMaximumLength(String name) {
    int blankSpaceNums = MAXIMUM_LENGTH - name.length();
    String blank = new String(new char[blankSpaceNums]).replace(NULL, BLANK);
    System.out.print(blank + name);
    System.out.print(BLANK_BETWEEN_NAMES);
 }

  private static void showLadder(Ladder ladder) {
    List<Row> rows = ladder.getRows();
    rows.forEach(ConsoleOutput::showRow);
  }

  private static void showRow(Row row) {
    System.out.print(LEFT_MARGIN);
    String rowStr = INITIAL_STRING;
    for (int position=0; position<row.getLenOfRow(); position++) {
      String line = row.getLineStartingWith(position);
      rowStr = rowStr.concat(BAR + line);
    }
    System.out.println(rowStr.concat(BAR));
  }

  private static void showGameResult(Map<User, Prize> prizes) {
    System.out.println(MESSAGE_WANT_TO_KNOW);
    String name = sc.nextLine();
    if (name.equals(ALL)) {
      showAllResult(prizes);
      return;
    }
    showUserResult(name, prizes);
  }

  private static void showAllResult(Map<User,Prize> prizes) {
    for (User user: prizes.keySet()) {
      System.out.println(user.getUserName().getName() + DELIMITER + prizes.get(user).getPrizeName());
    }
  }

  private static void showUserResult(String name, Map<User,Prize> prizes) {
    UserName userName = UserName.of(name);
    for (User user: prizes.keySet()) {
      if (user.hasUserName(userName)) {
        System.out.println(prizes.get(user).getPrizeName());
        return;
      }
    }
    System.out.println(MESSAGE_NOT_PARTICIPANT);
  }
}
