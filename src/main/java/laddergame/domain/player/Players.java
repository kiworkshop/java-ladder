package laddergame.domain.player;

import java.util.List;

public class Players {

    private static int playerCount;

    public static void calculatePlayerCount(List<String> playerNames) {
       playerCount = playerNames.size();
    }

    public static int getPlayerCount() {
        return playerCount;
    }
}
