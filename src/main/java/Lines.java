import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(int countOfPerson, int ladderHeight) {
        for(int i = 0; i < ladderHeight; i++){
            Line aLineOfLadder = new Line(countOfPerson);
            lines.add(aLineOfLadder);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
