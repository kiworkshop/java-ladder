package domain.ladder;

import java.util.List;

public class Row {

    private List<Step> steps;

    public Row(List<Step> steps) {
        this.steps = steps;
    }

    public int getNextIndexFrom(int index) {
        int prevIndex = index - 1;
        if (validateIndex(prevIndex) && existingStep(prevIndex)) {
            return --index;
        }
        if (validateIndex(index) && existingStep(index)) {
            return ++index;
        }
        return index;
    }

    private boolean existingStep(int index) {
        return steps.get(index).exist();
    }

    private boolean validateIndex(int index) {
        return 0 <= index && index < steps.size();
    }

    public List<Step> getSteps() {
        return steps;
    }
}
