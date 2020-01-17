import java.util.ArrayList;
import java.util.List;

public class Row {
  private int rowNum;
  private List<Point> points = new ArrayList<>();

  public Row(int rowNum, int numOfParticipants) {
    this.rowNum = rowNum;
    for (int i = 0; i < numOfParticipants; i++) {
      this.points.add(new Point());
    }
  }

  public void drawLadderLines(List<LadderPoint> ladderPoints) {
    for (LadderPoint ladderPoint : ladderPoints) {
      drawLadderLine(ladderPoint);
    }
  }

  private void drawLadderLine(LadderPoint ladderPoint) {
    if (ladderPoint.getY() == rowNum) {
      points.get(ladderPoint.getX() - 1).toConnected();
      points.get(ladderPoint.getX()).toConnected();
    }
  }

  public void print() {
    boolean prev = false;
    for (Point point : points) {
      if (point.isConnected() && prev) {
        System.out.print("------ |");
      } else {
        System.out.print("\t   |");
      }
      prev = point.isConnected();
    }
  }
}
