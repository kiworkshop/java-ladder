import java.util.List;

public class LadderInputData {

  public static final String ERROR_USER_NUMS_PRIZE_NUMS_NOT_EQUAL = "참가자 수와 게임 상품 수가 일치하지 않습니다.";

  private List<User> users;
  private LadderHeight height;
  private List<Prize> prizes;

  private LadderInputData(List<User> users, LadderHeight height, List<Prize> prizes) {
    validate(users, prizes);
    this.users = users;
    this.height = height;
    this.prizes = prizes;
  }

  private void validate(List<User> users, List<Prize> prizes) {
    if (users.size() != prizes.size()) {
      throw new IllegalArgumentException(ERROR_USER_NUMS_PRIZE_NUMS_NOT_EQUAL);
    }
  }

  public static LadderInputData of(List<User> users, LadderHeight height, List<Prize> prizes) {
    return new LadderInputData(users, height, prizes);
  }

  public List<User> getUsers() {
    return users;
  }

  public LadderHeight getHeight() {
    return height;
  }

  public List<Prize> getPrizes() {
    return prizes;
  }
}
