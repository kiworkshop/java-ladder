package domain.ladder;

import java.util.List;

public class Row {

    private List<Step> row;

    public Row(List<Step> row) {
        this.row = row;
    }

    public int getNextIndexFrom(int index) {
        int prevIndex = index - 1;
        if ( prevIndex >= 0 ) {
            if (row.get(prevIndex).exist()) {
                return --index;
            }
        }
        if (index <= row.size()) {
            if (row.get(index).exist()) {
                return ++index;
            }
        }
        return index;
    }
}
