package domain.ladder;

import java.util.List;

public class Row {

    private List<Step> steps;

    public Row(List<Step> steps) {
        this.steps = steps;
    }

    public int getNextIndexFrom(int index) {
        int prevIndex = index - 1;
        if ( prevIndex >= 0 ) {
            if (steps.get(prevIndex).exist()) {
                return --index;
            }
        }
        if (index <= steps.size()) {
            if (steps.get(index).exist()) {
                return ++index;
            }
        }
        return index;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
