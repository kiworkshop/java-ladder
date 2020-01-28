import java.util.ArrayList;
import java.util.List;

public class Ladder {
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

    private void build() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(width));
        }
    }
}
