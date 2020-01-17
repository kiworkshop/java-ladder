public class User {
  private String name;

  private User(String name) {
    this.name = name;
    validateName(name);
  }

  public static User of(String name) {
    return new User(name);
  }

  private void validateName(String name) {
    if (name.length() > 6) {
      throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
    }
  }
}
