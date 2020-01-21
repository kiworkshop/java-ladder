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
      points.get(ladderPoint.getX() - 1).toBarStart();
      points.get(ladderPoint.getX()).toBarEnd();
    }
  }

  public void print() {
    Point prev = new Point();
    for (Point point : points) {
      if (point.isBarEnd() && prev.isBarStart()) {
        System.out.print("------ |");
      } else {
        System.out.print("\t   |");
      }
      prev = point;
    }
  }
}
