import java.util.List;

public class InputValidator {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final String ERROR_MESSAGE_NAME_LENGTH_EXCEEDED = "이름이 5자를 초과할 수 없습니다.";

    public static void validatePlayerNames(List<String> playerNames) {
        for (String playerName : playerNames) {
            int playerNameLength = getPlayerNameLength(playerName);
            IsSmallerThanCriterion(playerNameLength);
        }
    }

    public static int getPlayerNameLength(String playerName) {
        return playerName.length();
    }

    public static void IsSmallerThanCriterion(int playerNameLength) {
        if (playerNameLength > PLAYER_NAME_MAX_LENGTH) {
            throw (new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH_EXCEEDED));
        }
    }
}
