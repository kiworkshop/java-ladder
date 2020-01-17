import java.util.ArrayList;
import java.util.List;

public class LadderGame {
  private List<Row> rows = new ArrayList<>();
  private List<LadderPoint> ladderPoints = new ArrayList<>();

  private LadderGame(List<Row> rows, List<LadderPoint> ladderPoints) {
    this.rows = rows;
    this.ladderPoints = ladderPoints;
  }

  public static LadderGame of(List<Row> rows, List<LadderPoint> ladderPoints) {
    return new LadderGame(rows, ladderPoints);
  }
}
