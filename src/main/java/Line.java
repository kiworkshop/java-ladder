import java.util.Objects;

public class Line {

  private final int startPosition;
  private final int endPosition;

  private Line(int startPosition, int endPosition) {
    this.startPosition = startPosition;
    this.endPosition = endPosition;
  }

  public static Line startWith(int startPosition) {
    return new Line(startPosition, startPosition + 1);
  }

  public int getStartPosition() {
    return startPosition;
  }

  public int getEndPosition() {
    return endPosition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Line line = (Line) o;
    return startPosition == line.startPosition &&
        endPosition == line.endPosition;
  }

  @Override
  public int hashCode() {
    return Objects.hash(startPosition, endPosition);
  }
}
