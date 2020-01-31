public class UserName {

  public static final int THRESHOLD = 5;
  public static final String ERROR_NAME_LENGTH_EXCEEDED = "이름이 5자 넘었습니다.";

  private final String name;

  private UserName(String name) {
    this.name = name;
  }

  public static UserName of(String name) {
    validate(name);
    return new UserName(name);
  }

  private static void validate(String name) {
    if (name.length() > THRESHOLD) {
      throw new IllegalArgumentException(ERROR_NAME_LENGTH_EXCEEDED);
    }
  }

  public String getName() {
    return name;
  }
}
