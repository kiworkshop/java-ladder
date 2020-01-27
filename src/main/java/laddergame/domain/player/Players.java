package laddergame.domain.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

    List<Player> players = new ArrayList<>();

    public Players(List<Player> players) {
        if (hasDuplicatedNamesIn(players)) {
            throw new IllegalArgumentException();
        }
        this.players = players;
    }

    private boolean hasDuplicatedNamesIn(List<Player> players) {
        Set<Player> nameSet = new HashSet<>(players);
        return players.size() != nameSet.size();
    }
}
