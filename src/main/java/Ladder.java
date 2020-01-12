import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Person> people;
    private int ladderHeight;
    private List<Line> ladder;

    public Ladder(List<Person> people, int ladderHeight) {
        this.people = people;
        this.ladderHeight = ladderHeight;
        this.ladder = new ArrayList<>();
        buildLadder();
    }

    private void buildLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(people.size()));
        }
    }

    public void printLadder() {
    }
}
