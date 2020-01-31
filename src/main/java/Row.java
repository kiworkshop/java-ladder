import java.util.List;
import java.util.Objects;

public class Row {

  private int lenOfRow;
  private List<Line> lines;

  private Row(int lenOfRow, List<Line> lines) {
    this.lenOfRow = lenOfRow;
    this.lines = lines;
  }

  public static Row of(int lenOfRow, List<Line> lines) {
    return new Row(lenOfRow, lines);
  }

  public int getNextPosition(int prevPosition) {
    if (hasLineStartingWith(prevPosition)) {
      return prevPosition + 1;
    }

    if (hasLineEndingWith(prevPosition)) {
      return prevPosition - 1;
    }

    return prevPosition;
  }

  public boolean hasLineStartingWith(int prevPosition) {
    return lines.stream().anyMatch(line -> line.isStartingWith(prevPosition));
  }

  private boolean hasLineEndingWith(int prevPosition) {
    return lines.stream().anyMatch(line -> line.isEndingWith(prevPosition));
  }

  public List<Line> getLines() {
    return lines;
  }

  public int getLenOfRow() {
    return lenOfRow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Row row = (Row) o;
    return Objects.equals(lines, row.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lines);
  }
}
