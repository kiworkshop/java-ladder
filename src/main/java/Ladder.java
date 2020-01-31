import java.util.List;

public class Ladder {

  private List<Row> rows;

  private Ladder(List<Row> rows) {
    this.rows = rows;
  }

  public static Ladder with(List<Row> rows) {
    return new Ladder(rows);
  }

  public int startWith(int initialPosition) {
    int position = initialPosition;
    for (Row row: rows) {
      position = row.getNextPosition(position);
    }
    return position;
  }

  public List<Row> getRows() {
    return rows;
  }
}
