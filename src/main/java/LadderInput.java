import java.util.List;

public class LadderInput {
    private List<Person> people;
    private int height;

    public LadderInput(List<Person> people, int height) {
        this.people = people;
        this.height = height;
    }

    public List<Person> getPeople() {
        return people;
    }

    public int getWidth() {
        return people.size() - 1;
    }

    public int getHeight() {
        return height;
    }
}
