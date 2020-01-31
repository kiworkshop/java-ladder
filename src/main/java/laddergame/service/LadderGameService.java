package laddergame.service;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.strategy.LadderCreationStrategy;
import laddergame.domain.ladderheight.LadderHeight;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;

import java.util.List;

public class LadderGameService {

    private static final String NAME_DELIMITER = ",";

    public Players createPlayers(String playerNames) {
        String[] parsedPlayerNames = parse(playerNames);
        List<Player> playerList = Players.createPlayerList(parsedPlayerNames);
        return new Players(playerList);
    }

    public Results createResults(String gameResults) {
        String[] parsedResultNames = parse(gameResults);
        List<Result> resultList = Results.createResultList(parsedResultNames);
        return new Results(resultList);
    }

    private String[] parse(String names) {
        return names.split(NAME_DELIMITER);
    }

    public LadderHeight createLadderHeight(int ladderHeightInput) {
        return new LadderHeight(ladderHeightInput);
    }

    public Ladder createLadder(Players players, LadderHeight ladderHeight, LadderCreationStrategy strategy) {
        return Ladder.with(players, ladderHeight, strategy);
    }
}
