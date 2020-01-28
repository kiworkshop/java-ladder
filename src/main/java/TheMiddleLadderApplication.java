import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheMiddleLadderApplication {

    public static final String NAME_DELIMITER = ",";

    public static void main(String[] args) {
        List<Person> people = makePeople(Input.inputNames());
        int ladderHeight = Input.inputLadderHeight();
        LadderInput ladderInput = new LadderInput(people, ladderHeight);
        Ladder.of(ladderInput);
    }

    private static List<Person> makePeople(String inputString) {
        return Arrays.stream(inputString.split(NAME_DELIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
