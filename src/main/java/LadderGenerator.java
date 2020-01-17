import java.util.List;

public class LadderGenerator {

    public static Ladder generateLadder() {
        List<Line> lines = LinesGenerator.generateLines();
        return new Ladder(lines);
    }

}
