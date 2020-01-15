public class LadderHeight {

  public static final int THRESHOLD = 1;
  public static final String ERROR_HEIGHT_SHORT = "사다리 높이가 1보다 작습니다.";

  private final int height;

  private LadderHeight(int height) {
    validate(height);
    this.height = height;
  }

  public static LadderHeight of(int height) {
    return new LadderHeight(height);
  }

  private void validate(int height) {
    if (height < THRESHOLD) {
      throw new IllegalArgumentException(ERROR_HEIGHT_SHORT);
    }
  }
  
  public int getHeight() {
    return height;
  }
}
