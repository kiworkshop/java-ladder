package laddergame.service;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.player.Players;

public class LadderGameService {

    public Players createPlayers(String playerNames) {
        return new Players();
    }

    public LadderHeight createLadderHeight(int ladderHightInput) {
        return new LadderHeight();
    }

    public Ladder createLadder(Players players, LadderHeight ladderHeight) {
        return new Ladder();
    }
}
