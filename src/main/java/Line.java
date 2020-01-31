import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    public static final String BAR_VERTICAL = "|";
    private List<Bar> bars;

    public Line(int width) {
        this.bars = new ArrayList<>();
        buildBars(width);
    }

    public Line(List<Bar> bars) {
        this.bars = bars;
    }

    private void buildBars(int width) {
        for (int i = 0; i < width; i++) {
            bars.add(Bar.ofRandom());
        }
        removeContinuousBars();
    }

    private void removeContinuousBars() {
        int endOfLeft = bars.size() - 1;
        for (int leftIndex = 0; leftIndex < endOfLeft; leftIndex++) {
            removeContinuousBar(leftIndex);
        }
    }

    private void removeContinuousBar(int leftIndex) {
        Bar left = bars.get(leftIndex);
        Bar right = bars.get(leftIndex + 1);
        if (isContinuous(left, right)) {
            disconnect(left, right);
        }
    }

    private void disconnect(Bar left, Bar right) {
        if (new Random().nextBoolean()) {
            left.disconnect();
            return;
        }
        right.disconnect();
    }

    private boolean isContinuous(Bar left, Bar right) {
        return left.isExists() && right.isExists();
    }

    public List<Bar> getBars() {
        return bars;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BAR_VERTICAL);
        for (Bar bar : bars) {
            stringBuilder.append(bar.toString());
            stringBuilder.append(BAR_VERTICAL);
        }
        return stringBuilder.toString();
    }

    public List<Person> playLineGame(List<Person> people) {
        for (int barIndex = 0; barIndex < bars.size(); barIndex++) {
            people = playBarGame(barIndex, bars.get(barIndex), people); //TODO need refactoring. 인수 3개까지 되던가?
        }
        Collections.sort(people);
        return people;
    }

    private List<Person> playBarGame(int barIndex, Bar bar, List<Person> people) {
        if (bar.isExists()) {
            people.get(barIndex).goRight();
            people.get(barIndex + 1).goLeft();
        }
        return people;
    }
}
