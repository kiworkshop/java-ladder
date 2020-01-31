public class LadderGameRunner {
  private UserInput userInput;
  private LadderGame ladderGame;

  public LadderGameRunner(UserInput userInput, LadderGame ladderGame) {
    this.userInput = userInput;
    this.ladderGame = ladderGame;
  }

  public static LadderGameRunner of(UserInput userInput, LadderGame ladderGame) {
    return new LadderGameRunner(userInput, ladderGame);
  }

  public void showGameResult() {
    int playingUserIndex = userInput.getPlayingUserIndex();
    if (playingUserIndex == userInput.getUsers().size()) {
      getAllGameResults();
      return;
    }
    getGameResult(playingUserIndex);
    showGameResult();
  }

  private void getAllGameResults() {
    for (int i = 0; i < userInput.getUsers().size(); i++) {
      int resultIndex = ladderGame.run(i);
      System.out.print(userInput.getUsers().get(resultIndex) + ": ");
      userInput.printResult(resultIndex);
    }
  }

  private void getGameResult(int playingUserIndex) {
    int resultIndex = ladderGame.run(playingUserIndex);
    userInput.printResult(resultIndex);
  }
}
