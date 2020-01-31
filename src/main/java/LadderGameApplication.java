public class LadderGameApplication {

  public static void main(String[] args) {
    UserInput userInput = new UserInput().getUserInput();
    LadderGameStarter ladderGameStarter = LadderGameStarter.from(userInput);
    LadderGame ladderGame = ladderGameStarter.createLadderGame();
    userInput.printUsers();
    ladderGame.printLadders();
    userInput.printResultOptions();
    LadderGameRunner.of(userInput, ladderGame).showGameResult();
  }
}
