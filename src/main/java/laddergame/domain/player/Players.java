package laddergame.domain.player;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(final List<Player> players) {
        if (hasDuplicatedNames(players)) {
            throw new IllegalArgumentException();
        }

        this.players = players;
    }

    private boolean hasDuplicatedNames(final List<Player> players) {
        Set<Player> nameSet = new HashSet<>(players);
        return players.size() != nameSet.size();
    }

    public int size() {
        return players.size();
    }

    public static List<Player> createPlayerList(String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public String getAlignedPlayerNames() {
        List<String> playerNames = playerNamesToList();

        List<String> alignedPlayerNames = alignPlayerNames(playerNames);

        return playerNamesToString(alignedPlayerNames);
    }

    private List<String> playerNamesToList() {
        List<String> playerNames = new ArrayList<>();

        players.forEach(player -> playerNames.add(player.getName()));
        return playerNames;
    }

    private List<String> alignPlayerNames(List<String> playerNames) {
        List<String> alignedPlayerNames = new ArrayList<>();

        for (String playerName : playerNames) {
            String alignedPlayerName = alignPlayerName(playerName);
            alignedPlayerNames.add(alignedPlayerName);
        }
        return alignedPlayerNames;
    }

    private String alignPlayerName(String playerName) {
        return StringUtils.leftPad(playerName, Player.PLAYER_NAME_MAX_LENGTH + 1);
    }

    private String playerNamesToString(List<String> playerNames) {
        String alignedPlayerNames ="";

        for (String playerName : playerNames) {
            alignedPlayerNames += playerName;
        }
        return alignedPlayerNames;
    }
}
