public class Application {
  public static void main(String[] args) {
    LadderGameInputData ladderGameInputData = ConsoleInput.getLadderGameInputData();
    LadderGame ladderGame = LadderGame.with(ladderGameInputData, new RandomRowGeneratorStrategy());
    ladderGame.generateLadder();
    ladderGame.run();
    LadderGameOutputData ladderGameOutputData = ladderGame.getLadderGameOutputData();
    ConsoleOutput.showLadderGameResultWith(ladderGameOutputData);
  }
}
