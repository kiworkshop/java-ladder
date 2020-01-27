import java.util.ArrayList;
import java.util.List;

public class Row {
  private int rowNum;
  private List<Point> points = new ArrayList<>();

  private Row(int rowNum, int numOfParticipants) {
    this.rowNum = rowNum;
    for (int i = 0; i < numOfParticipants; i++) {
      this.points.add(new Point());
    }
  }

  public static Row of(int rowNum, int numOfParticipants) {
    return new Row(rowNum, numOfParticipants);
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

  public int move(int xIndex) {
    Point currentPoint = points.get(xIndex);
    if (currentPoint.isBarStart()) {
      return xIndex + 1;
    }
    if (currentPoint.isBarEnd()) {
      return xIndex - 1;
    }
    return xIndex;
  }
}
