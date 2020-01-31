import java.util.List;

public class ConsoleOutput {


    public static void printPeople(List<Person> people) {
        for (Person person : people) {
            System.out.printf("%-6s", person.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printResults(List<GameResult> results) {
        for (GameResult gameResult : results) {
            System.out.printf("%-6s", gameResult.getName());
        }
        System.out.println();
    }

    public static void printAllResults(List<Person> peoplePlayed, List<GameResult> results) {
        System.out.println("실행결과");
        for (int i = 0; i < peoplePlayed.size(); i++) {
            System.out.println(peoplePlayed.get(i).getName() + " : " + results.get(i).getName());
        }
        System.out.println();
    }
}
