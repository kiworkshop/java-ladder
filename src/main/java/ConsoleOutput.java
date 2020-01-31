import java.util.List;

public class ConsoleOutput {


    public static final String MESSAGE_RESULT_PRINT = "실행결과";
    public static final String DELIMITER_NAME_RESULT = " : ";
    public static final String FORMATTER_NAME = "%-6s";

    public static void printPeople(List<Person> people) {
        for (Person person : people) {
            System.out.printf(FORMATTER_NAME, person.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printResults(List<GameResult> results) {
        for (GameResult gameResult : results) {
            System.out.printf(FORMATTER_NAME, gameResult.getName());
        }
        System.out.println();
    }

    public static void printAllResults(List<Person> peoplePlayed, List<GameResult> results) {
        printResultMessage();
        for (int i = 0; i < peoplePlayed.size(); i++) {
            System.out.println(peoplePlayed.get(i).getName() + DELIMITER_NAME_RESULT + results.get(i).getName());
        }
        System.out.println();
    }

    public static void printOneResult(String result) {
        printResultMessage();
        System.out.println(result);
    }

    private static void printResultMessage() {
        System.out.println(MESSAGE_RESULT_PRINT);
    }
}
