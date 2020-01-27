package laddergame.service;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladderheight.LadderHeight;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {

    private static final String DELIMITER_PLAYER_NAME = ",";

    public Players createPlayers(String playerNames) {
        String[] parsedPlayerNames = parsePlayerNames(playerNames);
        List<Player> playerList = createPlayerList(parsedPlayerNames);
        return new Players(playerList);
    }

    private String[] parsePlayerNames(String playerNames) {
        return playerNames.split(DELIMITER_PLAYER_NAME);
    }

    private List<Player> createPlayerList(String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public LadderHeight createLadderHeight(int ladderHightInput) {
        return new LadderHeight(ladderHightInput);
    }

    public Ladder createLadder(Players players, LadderHeight ladderHeight) {
        return new Ladder();
    }
}
