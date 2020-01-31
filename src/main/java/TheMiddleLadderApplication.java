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

        ConsoleOutput.printPeople(people);
        ConsoleOutput.printLadder(ladder);
        ConsoleOutput.printResults(results);

        List<Person> peoplePlayed = ladder.playLadderGame(people);

    }

    private static List<GameResult> makeGameResult(String inputResults) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputResults.split(NAME_DELIMITER))
                .map((String name) -> new GameResult(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    private static List<Person> makePeople(String inputString) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputString.split(NAME_DELIMITER))
                .map((String name) -> new Person(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

}
