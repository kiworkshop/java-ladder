package laddergame.domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        if (hasDuplicatedNamesIn(players)) {
            throw new IllegalArgumentException();
        }

        this.players = players;
    }

    private boolean hasDuplicatedNamesIn(final List<Player> players) {
        Set<Player> nameSet = new HashSet<>(players);
        return players.size() != nameSet.size();
    }

    public int size() {
        return players.size();
    }
}
