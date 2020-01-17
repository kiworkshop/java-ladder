import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGameInput {

    public static final String DELIMITER = ",";

    private static List<String> playerNames = new ArrayList<>();
    private static int ladderHeight;

    public static List<String> getPlayerNamesFromInputScanner(InputScanner playerNamesScanner) {
        String playerNamesString = playerNamesScanner.getPlayerNamesFromUser();
        return covertStringToArrayList(playerNamesString);
    }

    public static List<String> covertStringToArrayList(String playerNamesString) {
        String[] tokens = generateStringTokensByDelimiter(playerNamesString);
        return playerNames = Arrays.asList(tokens);
    }

    public static String[] generateStringTokensByDelimiter(String playerNamesString) {
        return playerNamesString.split(DELIMITER);
    }

    public static int getLadderHeightFromInputScanner(InputScanner ladderHeightScanner) {
        return ladderHeight = ladderHeightScanner.getLadderHeightFromUser();
    }

    public static List<String> getPlayerNames() {
        return playerNames;
    }

    public static int getLadderHeight() {
        return ladderHeight;
    }
}
