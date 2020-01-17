import java.util.List;
import java.util.Objects;

public class Row {

  public static final String ROW_BAR = "|";
  public static final String LINE = "-----";
  public static final String BLANK_SPACE_BETWEEN_BARS = "     ";
  public static final String HEAD_OF_ROW = "   ";

  private int lenOfRow;
  private List<Line> lines;

  private Row(int lenOfRow, List<Line> lines) {
    this.lenOfRow = lenOfRow;
    this.lines = lines;
  }

  public static Row of(int lenOfRow, List<Line> lines) {
    return new Row(lenOfRow, lines);
  }

  public void show() {
    String row = rowToString();
    System.out.print(HEAD_OF_ROW);
    System.out.println(row);
  }

  private String rowToString() {
    String row = "";
    for (int position=0; position<lenOfRow; position++) {
      String line = getLineStartingWith(position);
      row = row.concat(ROW_BAR + line);
    }
    return row.concat(ROW_BAR);
  }

  private String getLineStartingWith(int point) {
    boolean isLineStartingWithPointExist = lines.stream().anyMatch(line -> line.isStartingWith(point));
    if (isLineStartingWithPointExist) {
      return LINE;
    }
    return BLANK_SPACE_BETWEEN_BARS;
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
