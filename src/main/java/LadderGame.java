import java.util.List;

public class LadderGame {

  public static final String BLANK_BETWEEN_NAMES = "  ";
  public static final String NEXT = "\n";

  private List<User> users;
  private LadderHeight height;
  private LadderGenerator ladderGenerator;
  private Ladder ladder;

  private LadderGame(LadderInputData ladderInputData, RowGeneratorStrategy rowGeneratorStrategy) {
    this.users = ladderInputData.getUsers();
    this.height = ladderInputData.getHeight();
//   TODO 생성자에서 데이터를 넣어주느냐 vs 메서드 파라미터로 넣어주느냐 ( 각각 어떤 변화들을 야기하는가?!)
//    TODO 파라미터로 넣어주면 generateRows에 자유도가 생김.
    this.ladderGenerator = new LadderGenerator(rowGeneratorStrategy);
  }

  public static LadderGame with(LadderInputData ladderInputData, RowGeneratorStrategy rowGeneratorStrategy) {
    return new LadderGame(ladderInputData, rowGeneratorStrategy);
  }

  public void generateLadder() {
    int numOfColumn = users.size();
    ladder = ladderGenerator.generateLadder(numOfColumn, height.getHeight());
  }

  public List<User> getUsers() {
    return users;
  }

  public LadderHeight getHeight() {
    return height;
  }

  public LadderGenerator getLadderGenerator() {
    return ladderGenerator;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public void showLadderGame() {
    showUsers();
    showLadder();
  }

  private void showUsers() {
    for (User user: users) {
      user.showUserName();
      System.out.print(BLANK_BETWEEN_NAMES);
    }
    moveToNextRow();
  }

  private void moveToNextRow() {
    System.out.print(NEXT);
  }

  private void showLadder() {
    ladder.show();
  }
}
