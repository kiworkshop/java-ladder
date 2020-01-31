import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    public static final String DELIMITER_LINE = "\n";
    private int width;
    private int height;
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        build();
    }

    public static Ladder of(LadderInput ladderInput) {
        return new Ladder(ladderInput.getWidth(), ladderInput.getHeight());
    }

    public String toString() {
        return ladder.stream().map(Line::toString).collect(Collectors.joining(DELIMITER_LINE));
    }

    private void build() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(width));
        }
    }

    public List<Person> playLadderGame(List<Person> people) {
        for (Line line : ladder) {
            people = line.playLineGame(people);
        }
        return people;
    }
}
