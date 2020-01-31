import java.util.HashMap;
import java.util.List;

public class LadderGame {

  private List<User> users;
  private LadderHeight height;
  private List<Prize> prizes;
  private Ladder ladder;
  private LadderGenerator ladderGenerator;
  private HashMap<User, Prize> ladderResult = new HashMap<>();

  private LadderGame(LadderGameInputData ladderGameInputData, RowGeneratorStrategy rowGeneratorStrategy) {
    this.users = ladderGameInputData.getUsers();
    this.height = ladderGameInputData.getHeight();
    this.prizes = ladderGameInputData.getPrizes();
//   TODO 생성자에서 데이터를 넣어주느냐 vs 메서드 파라미터로 넣어주느냐 ( 각각 어떤 변화들을 야기하는가?!)
//    TODO 파라미터로 넣어주면 generateRows에 자유도가 생김.
    this.ladderGenerator = new LadderGenerator(rowGeneratorStrategy);
  }

  public static LadderGame with(LadderGameInputData ladderGameInputData, RowGeneratorStrategy rowGeneratorStrategy) {
    return new LadderGame(ladderGameInputData, rowGeneratorStrategy);
  }

  public void generateLadder() {
    int numOfColumn = users.size();
    ladder = ladderGenerator.generateLadder(numOfColumn, height.getHeight());
  }

  public void run() {
    users.forEach(this::runWith);
  }

  private void runWith(User user) {
    int position = ladder.startWith(user.getPosition());
    Prize prize = prizes.stream()
        .filter(p -> p.hasPosition(position))
        .findAny().orElseThrow(IllegalArgumentException::new);
    ladderResult.put(user, prize);
  }

  public LadderGameOutputData getLadderGameOutputData() {
    return LadderGameOutputData.of(users, prizes, ladder, ladderResult);
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
}
