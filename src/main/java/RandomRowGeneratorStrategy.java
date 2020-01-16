import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowGeneratorStrategy implements RowGeneratorStrategy{

  public static final int FIRST_COLUMN = 0;

  public static Random random = new Random();

  @Override
  public Row generateRow(int numOfColumn) {
    return Row.of(generateNonSequentialRandomLines(numOfColumn));
  }

  public List<Line> generateNonSequentialRandomLines(int numOfColumn) {
    List<Line> lines = new ArrayList<>();

    int nthColumn = FIRST_COLUMN;
    while (nthColumn < numOfColumn) {
      nthColumn = addNthColumn(lines, nthColumn);
    }

    return lines;
  }

  private int addNthColumn(List<Line> lines, int nthColumn) {
    boolean isRow = random.nextBoolean();
    if (isRow) {
      lines.add(Line.startWith(nthColumn));
      nthColumn += 2;
      return nthColumn;
    }
    nthColumn++;
    return nthColumn;
  }
}
