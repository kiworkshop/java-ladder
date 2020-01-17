import java.util.ArrayList;
import java.util.List;

import toStash.Point;

public class Row {
  private int rowNum;
  private List<Point> points = new ArrayList<>();

  public Row(int rowNum, int numOfParticipants) {
    this.rowNum = rowNum;
    for (int i = 0; i < numOfParticipants; i++) {
      this.points.add(new Point());
    }
  }

  public void drawLadderLine(List<LadderPoint> ladderPoints) {
    for (LadderPoint ladderPoint : ladderPoints) {
      if (ladderPoint.getY() == rowNum) {
        points.get(ladderPoint.getX() - 1).toConnected();
        points.get(ladderPoint.getX()).toConnected();
      }
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
