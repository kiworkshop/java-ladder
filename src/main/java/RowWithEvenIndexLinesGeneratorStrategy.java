import java.util.ArrayList;
import java.util.List;

public class RowWithEvenIndexLinesGeneratorStrategy implements RowGeneratorStrategy {
  public List<Line> generateLines(int numOfLines) {
    List<Line> lines = new ArrayList<>();
    for (int i=0; i<numOfLines; i++) {
      if (i % 2 == 0) {
        Line line = Line.startWith(i);
        lines.add(line);
      }
    }
    return lines;
  }

  @Override
  public Row generateRow(int lenOfRow) {
    return Row.of(lenOfRow, generateLines(lenOfRow));
  }
}
