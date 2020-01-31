import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        for(int i = 0; i < ladderHeight; i++){
            Line aLineOfLadder = new Line(countOfPerson);
            ladder.add(aLineOfLadder);
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
