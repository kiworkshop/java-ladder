public class Point {
  private boolean isConnected;

  public Point() {}

  public Point(boolean isConnected) {
    this.isConnected = isConnected;
  }

  public void toConnected() {
    this.isConnected = true;
  }

  public boolean isConnected() {
    return isConnected;
  }
}
