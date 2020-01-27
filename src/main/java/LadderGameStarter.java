import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGameStarter {
  private int width;
  private int height;

  private LadderGameStarter(UserInput userInput) {
    this.width = userInput.getUsers().size();
    this.height = userInput.getHeight();
  }

  public static LadderGameStarter from(UserInput userInput) {
    return new LadderGameStarter(userInput);
  }

  public LadderGame createLadderGame() {
    List<Row> rows = generateRows();
    List<LadderPoint> ladderPoints = generateLadderPoints();
    return LadderGame.of(rows, ladderPoints);
  }

  private List<Row> generateRows() {
    List<Row> rows = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      rows.add(Row.of(i, width));
    }
    return rows;
  }

  protected List<LadderPoint> generateLadderPoints() {
    List<LadderPoint> ladderPoints = new ArrayList<>();
    List<Integer> prevRandomNumbers = new ArrayList<>();
    for (int i = 1; i < width; i++) {
      List<Integer> randomNumbers = generateRandomNumbers(height, prevRandomNumbers);
      for (Integer rand : randomNumbers) {
        ladderPoints.add(new LadderPoint(i, rand));
      }
      prevRandomNumbers = randomNumbers;
    }
    return ladderPoints;
  }

  List<Integer> generateRandomNumbers(int bound, List<Integer> excludingNums) {
    List<Integer> randomNumbers = new ArrayList<>();
    int numOfRandomNumbers = generateRandomNum(bound - excludingNums.size(), new ArrayList<>());
    for (int i = 0; i < numOfRandomNumbers; i++) {
      randomNumbers.add(generateRandomNum(bound, excludingNums));
    }
    return randomNumbers;
  }

  int generateRandomNum(int bound, List<Integer> excludingNums) {
    int rand = new Random().nextInt(bound);
    if (excludingNums.contains(rand) || rand == 0) {
      return generateRandomNum(bound, excludingNums);
    }
    return rand;
  }

}
