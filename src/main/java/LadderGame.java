import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> playerNames = LadderGameInput.getPlayerNamesFromInputScanner(new InputScanner());
        InputValidator.validatePlayerNames(playerNames);
        InputScanner.printSeparationLine();
        int ladderHeight = LadderGameInput.getLadderHeightFromInputScanner(new InputScanner());
        InputScanner.printSeparationLine();

        LadderGamePlayers.calculatePlayerCount(playerNames);
        int playerCount = LadderGamePlayers.getPlayerCount();

        Ladder ladder = LadderGenerator.generateLadder();

        LadderGamePrinter.printLadderGame(ladder);
    }

}
