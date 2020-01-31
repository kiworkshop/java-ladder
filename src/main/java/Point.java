public class Point {
  private boolean isBarStart;
  private boolean isBarEnd;

  public Point() {}

  public void toBarStart() {
    this.isBarStart = true;
  }

  public void toBarEnd() {
    this.isBarEnd = true;
  }

  public boolean isBarStart() {
    return this.isBarStart;
  }

  public boolean isBarEnd() {
    return this.isBarEnd;
  }
}
