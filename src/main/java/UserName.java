public class UserName {
  private String name;

  private UserName(String name) {
    this.name = name;
    validate(name);
  }

  public static UserName of(String name) {
    return new UserName(name);
  }

  private void validate(String name) {
    if (name.length() > 6) {
      throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
    }
  }
}
