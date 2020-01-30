import java.util.Arrays;
import java.util.List;
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
    }

    private static List<GameResult> makeGameResult(String inputResults) {
        return Arrays.stream(inputResults.split(NAME_DELIMITER))
                .map(GameResult::new)
                .collect(Collectors.toList());
    }

    private static List<Person> makePeople(String inputString) {
        return Arrays.stream(inputString.split(NAME_DELIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
