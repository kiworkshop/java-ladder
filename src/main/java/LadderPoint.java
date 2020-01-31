import java.util.Objects;

public class LadderPoint {
  int x;
  int y;

  public LadderPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static LadderPoint of(int x, int y) {
    return new LadderPoint(x, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderPoint that = (LadderPoint) o;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
