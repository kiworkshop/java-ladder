public class Prize {

  private String prizeName;
  private int position;

  private Prize(String prizeName, int position) {
    this.prizeName = prizeName;
    this.position = position;
  }

  public static Prize with(String prizeName, int position) {
    return new Prize(prizeName, position);
  }

  public String getPrizeName() {
    return prizeName;
  }

  public int getPosition() {
    return position;
  }
}
