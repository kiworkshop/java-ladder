import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = makePeople(Input.inputNames());
        int ladderHeight = Input.inputLadderHeight();

    }

    private static List<Person> makePeople(String inputString) {
        List<Person> people = new ArrayList<>();
        String[] names = splitNames(inputString, ",");
        for (String name : names) {
            Person person = new Person(name);
            people.add(person);
        }
        return people;
    }

    public static String[] splitNames(String inputString, String regex) {
        return inputString.split(regex);
    }

    private static void makeLadder() {
    }
}
