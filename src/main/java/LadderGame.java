import java.util.ArrayList;
import java.util.List;

public class LadderGame {
  private List<Row> rows = new ArrayList<>();

  private LadderGame(List<Row> rows) {
    this.rows = rows;
  }

  public static LadderGame of(List<Row> rows, List<LadderPoint> ladderPoints) {
    for (Row row : rows) {
      row.drawLadderLines(ladderPoints);
    }
    return new LadderGame(rows);
  }

  public void printLadders() {
    for (Row row : rows) {
      row.print();
      System.out.println();
    }
  }

  public int run(int playerIndex) {
    for (Row row : rows) {
      playerIndex = row.move(playerIndex);
    }
    return playerIndex;
  }
}
