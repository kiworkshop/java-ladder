import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGameStarter {
  private List<User> users = new ArrayList<>();
  private int height;

  private LadderGameStarter(UserInput userInput) {
    this.users = userInput.getUsers();
    this.height = userInput.getHeight();
  }

  public static LadderGameStarter from(UserInput userInput) {
    return new LadderGameStarter(userInput);
  }

  public LadderGame createLadderGame() {
    List<Row> rows = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      rows.add(new Row(i, users.size()));
    }
    List<LadderPoint> ladderPoints = generateLadderPoints();
    return LadderGame.of(rows, ladderPoints);
  }

  public List<LadderPoint> generateLadderPoints() {
    List<LadderPoint> ladderPoints = new ArrayList<>();
    int prevNum = -1;
    for (int i = 1; i < users.size(); i++) {
      int rand = generateRandomNum(height, prevNum);
      ladderPoints.add(new LadderPoint(i, rand));
      prevNum = rand;
    }
    return ladderPoints;
  }

  int generateRandomNum(int bound, int excludingNum) {
    int rand = new Random().nextInt(bound);
    if (excludingNum == rand) {
      return generateRandomNum(bound, excludingNum);
    }
    return rand;
  }

  public void printUsers() {
    for (User user: users) {
      System.out.print("  " + user + "\t  ");
    }
    System.out.println();
  }
}
