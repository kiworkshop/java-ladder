public class Application {
  public static void main(String[] args) {
    LadderInputData ladderInputData = ConsoleInput.getLadderData();
    LadderGame ladderGame = LadderGame.with(ladderInputData, new RandomRowGeneratorStrategy());
    ladderGame.generateLadder();
  }
}
