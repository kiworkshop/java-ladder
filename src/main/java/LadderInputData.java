import java.util.List;

public class LadderInputData {

  private List<User> users;
  private LadderHeight height;

  private LadderInputData(List<User> users, LadderHeight height) {
    this.users = users;
    this.height = height;
  }

  public static LadderInputData of(List<User> users, LadderHeight height) {
    return new LadderInputData(users, height);
  }

  public List<User> getUsers() {
    return users;
  }

  public LadderHeight getHeight() {
    return height;
  }
}
