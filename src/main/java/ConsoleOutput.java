import java.util.List;
import java.util.Map;

public class ConsoleOutput {

  public static final String MESSAGE_LADDER_GAME_RESULT = "사다리 결과";
  public static final String NULL = "\0";
  public static final String BLANK_BETWEEN_NAMES = "  ";
  public static final String NEXT_LINE = "\n";
  public static final String LINE = "-----";
  public static final String EMPTY = "     ";
  public static final String INITIAL_STRING = "";
  public static final String BAR = "|";
  private static final int MAXIMUM_LENGTH = 5;

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
    String blank = new String(new char[blankSpaceNums]).replace(NULL, " ");
    System.out.print(blank + name);
    System.out.print(BLANK_BETWEEN_NAMES);
 }

  private static void showLadder(Ladder ladder) {
    List<Row> rows = ladder.getRows();
    rows.forEach(ConsoleOutput::showRow);
  }

  private static void showRow(Row row) {
    System.out.print("   ");
    String rowStr = INITIAL_STRING;
    for (int position=0; position<row.getLenOfRow(); position++) {
      String line = INITIAL_STRING;
      if (row.hasLineStartingWith(position)) {
        line = LINE;
      }
      if (!row.hasLineStartingWith(position)) {
        line = EMPTY;
      }
      rowStr = rowStr.concat(BAR + line);
    }
    System.out.println(rowStr.concat(BAR));
  }

  private static void showGameResult(Map<User, Prize> prizes) {

  }
}
