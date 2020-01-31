public class ResultOption {
  private String result;

  public ResultOption(String result) {
    this.result = result;
  }

  public static ResultOption of(String result) {
    return new ResultOption(result);
  }

  @Override
  public String toString() {
    return this.result;
  }
}
