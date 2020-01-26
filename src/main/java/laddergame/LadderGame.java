package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGameInput;
import laddergame.domain.LadderGamePlayers;
import laddergame.domain.LadderGenerator;
import laddergame.view.InputScanner;
import laddergame.view.InputValidator;
import laddergame.view.LadderGamePrinter;

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
