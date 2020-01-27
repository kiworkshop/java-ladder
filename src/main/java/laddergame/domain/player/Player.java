package laddergame.domain.player;

import java.util.Objects;

public class Player {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    private boolean isLongerThanMaxLength(final String name) {
        return name.length() > PLAYER_NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
