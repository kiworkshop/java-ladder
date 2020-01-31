import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TheMiddleLadderApplication {

    public static final String NAME_DELIMITER = ",";

    public static void main(String[] args) {
        List<Person> people = makePeople(Input.inputNames());
        List<GameResult> results = makeGameResult(Input.inputResults());
        int ladderHeight = Input.inputLadderHeight();
        LadderInput ladderInput = new LadderInput(people, ladderHeight);
        Ladder ladder = Ladder.of(ladderInput);

        printLadderGameGraphics(people, ladder, results);

        List<Person> peoplePlayed = ladder.playLadderGame(people);
        while (true) {
            showGameResults(peoplePlayed, results);
        }
    }

    private static void printLadderGameGraphics(List<Person> people, Ladder ladder, List<GameResult> results) {
        ConsoleOutput.printPeople(people);
        ConsoleOutput.printLadder(ladder);
        ConsoleOutput.printResults(results);
    }

    private static void showGameResults(List<Person> peoplePlayed, List<GameResult> results) {
        String targetUserName = Input.printResultAsk();
        if (targetUserName.equals("all")) {
            ConsoleOutput.printAllResults(peoplePlayed, results);
            return;
        }
        int targetUserPosition = peoplePlayed
                .stream()
                .filter(person -> person.getName()
                        .equals(targetUserName))
                .collect(Collectors.toList())
                .get(0)
                .getPosition();
        String result = results.get(targetUserPosition).getName();
        ConsoleOutput.printOneResult(result);
    }


    private static List<GameResult> makeGameResult(String inputResults) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputResults.split(NAME_DELIMITER))
                .map((String name) -> new GameResult(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public static List<Person> makePeople(String inputString) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputString.split(NAME_DELIMITER))
                .map((String name) -> new Person(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

}
