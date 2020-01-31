package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.strategy.RandomLadderCreationStrategy;
import laddergame.domain.ladderheight.LadderHeight;
import laddergame.domain.player.Players;
import laddergame.domain.result.Results;
import laddergame.service.LadderGameService;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGameService ladderGameService = new LadderGameService();

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String playerNames = inputView.getPlayerNamesFromConsole();
        Players players = ladderGameService.createPlayers(playerNames);

        String gameResults = inputView.getGameResultFromConsole();
        Results results = ladderGameService.createResults(gameResults, players.size());

        int ladderHeightInput = inputView.getLadderHeightFromConsole();
        LadderHeight ladderHeight = ladderGameService.createLadderHeight(ladderHeightInput);

        Ladder ladder = ladderGameService.createLadder(players, ladderHeight, new RandomLadderCreationStrategy());

        //LadderGame ladderGame = ladderGameService.createLadderGame(players, results, ladder);

        outputView.printResult(players, ladder);
    }
}
