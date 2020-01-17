import java.util.List;

public class Ladder {

  private List<Row> rows;

  private Ladder(List<Row> rows) {
    this.rows = rows;
  }

  public static Ladder with(List<Row> rows) {
    return new Ladder(rows);
  }

  public List<Row> getRows() {
    return rows;
  }

  public void show() {
    rows.forEach(Row::show);
  }
}
