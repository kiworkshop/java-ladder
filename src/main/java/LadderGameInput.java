import java.util.Arrays;
import java.util.List;

public class LadderGameInput {

    public static final String DELIMITER = ",";

    private List<String> playerNames;
    private int ladderHeight;

    public void getPlayerNamesFromInputScanner(InputScanner playerNamesScanner) {
        String playerNamesString = playerNamesScanner.getPlayerNamesFromUser();
        playerNames = Arrays.asList(playerNamesString.split(DELIMITER));
    }

    public void getLadderHeightFromInputScanner(InputScanner ladderHeightScanner ) {
        ladderHeight = ladderHeightScanner.getLadderHeightFromUser();
    }

    public InputScanner generateInputScanner() {
        return new InputScanner();
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
