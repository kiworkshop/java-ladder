public class Main {

  public static void main(String[] args) {
    UserInput userInput = new UserInput().getUserInput();
    LadderGameStarter ladderGameStarter = LadderGameStarter.from(userInput);
    LadderGame ladderGame = ladderGameStarter.createLadderGame();
    userInput.printUsers();
    ladderGame.printLadders();
    userInput.printResultOptions();
    // TODO: 2020-01-27 while achieving a certain condition....
    while (true) {
      int resultIndex = ladderGame.run(userInput.getPlayingUserIndex());
      userInput.printResult(resultIndex);
    }
  }
}
