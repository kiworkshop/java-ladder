package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGameInput;
import laddergame.domain.LadderGamePlayers;
import laddergame.domain.LadderGenerator;
import laddergame.view.InputScanner;
import laddergame.view.InputValidator;
import laddergame.view.InputView;
import laddergame.view.LadderGamePrinter;

public class LadderGameController {

    private final InputView inputView;

    public LadderGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String playerNames = inputView.getPlayerNamesFromConsole();
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
