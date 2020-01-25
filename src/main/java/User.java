public class User {
  private static final int MAX_LENGTH = 5;
  private String name;

  private User(String name) {
    this.name = name;
    validateName(name);
  }

  public static User of(String name) {
    return new User(name);
  }

  private void validateName(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
