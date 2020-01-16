import java.util.List;
import java.util.Objects;

public class Row {

  private List<Line> lines;

  private Row(List<Line> lines) {
    this.lines = lines;
  }

  public static Row of(List<Line> lines) {
    return new Row(lines);
  }

  public List<Line> getLines() {
    return lines;
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
