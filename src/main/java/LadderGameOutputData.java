import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameOutputData {

  private List<User> users;
  private List<Prize> prizes;
  private Ladder ladder;
  private Map<User, Prize> ladderResult;

  private LadderGameOutputData(List<User> users, List<Prize> prizes, Ladder ladder, Map<User, Prize> ladderResult) {
    this.users = users;
    this.prizes = prizes;
    this.ladder = ladder;
    this.ladderResult = ladderResult;
  }

  public static LadderGameOutputData of(List<User> users, List<Prize> prizes, Ladder ladder, HashMap<User,Prize> ladderResult) {
    return new LadderGameOutputData(users, prizes, ladder, ladderResult);
  }

  public List<User> getUsers() {
    return users;
  }

  public List<Prize> getPrizes() {
    return prizes;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public Map<User, Prize> getLadderResult() {
    return ladderResult;
  }
}
