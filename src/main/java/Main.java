public class Main {
  UserInput userInput = new UserInput().getUserInput();
  LadderGameStarter ladderGameStarter = LadderGameStarter.from(userInput);
  LadderGame ladderGame = ladderGameStarter.createLadderGame();

}
