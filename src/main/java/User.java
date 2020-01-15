public class User {

  private final UserName userName;
  private final int position;

  private User(UserName userName, int position) {
    this.userName = userName;
    this.position = position;
  }

  public static User with(UserName name, int position) {
    return new User(name, position);
  }

  public UserName getUserName() {
    return userName;
  }

  public int getPosition() {
    return position;
  }
}
