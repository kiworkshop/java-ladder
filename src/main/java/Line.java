import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    public static final String BAR_VERTICAL = "|";
    public static final double BAR_EXIST_PERCENTAGE = 0.5;
    private int barNumber;
    private List<Bar> bars;

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

    public Line(int size) {
        this.barNumber = size - 1;
        this.bars = new ArrayList<>();
        buildBars();
    }

    private void buildBars() {
        for (int i = 0; i < barNumber; i++) {
            bars.add(new Bar(makeEachBar()));
        }

    }

    private boolean makeEachBar() {
        if (bars.size() == 0) {
            return getRandomBoolean();
        }
        if (bars.get(bars.size() - 1).isBarExist()) {
            return false;
        }
        return getRandomBoolean();
    }

    private boolean getRandomBoolean() {
        return Math.random() > BAR_EXIST_PERCENTAGE;
    }

}
