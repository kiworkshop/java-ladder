import java.util.ArrayList;
import java.util.List;

public class LadderGamePrinter {
    private static Ladder ladder;

    public static void printLadderGame(Ladder ladder) {
        LadderGamePrinter.ladder = ladder;
        printPlayerName();
        printRow();
    }

    private static void printPlayerName() {
        List<String> playerNames = LadderGameInput.getPlayerNames();
        System.out.println(playerNames);
    }

    private static void printRow() {

    }

    private static List<Line> generateRow(int rowIndex) {

    }

}
