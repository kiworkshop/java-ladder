import java.util.ArrayList;
import java.util.List;

public class Line {

    private int barNumber;
    private List<Boolean> bars;
    private List<Double> randomNumberForEachBar;

    public Line(int size) {
        this.barNumber = size - 1;
        this.bars = new ArrayList<>();
        this.randomNumberForEachBar = new ArrayList<Double>();
        buildBars();
    }

    private void buildBars() {
        getRandomNumberForEachBar();
        makeBars();


    }

    private void makeBars() {
        for (Double randomNumber : randomNumberForEachBar) {
            if (randomNumber > 0.5) {
                bars.add(true);
            }
            if (randomNumber <= 0.5) {
                bars.add(false);
            }
        }
    }

    private void getRandomNumberForEachBar() {
        for (int i = 0; i < barNumber; i++) {
            randomNumberForEachBar.add(Math.random());
        }
    }


}
