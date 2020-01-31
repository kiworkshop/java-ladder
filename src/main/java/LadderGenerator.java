import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

  private RowGeneratorStrategy rowGeneratorStrategy;

  public LadderGenerator(RowGeneratorStrategy rowGeneratorStrategy) {
   this.rowGeneratorStrategy = rowGeneratorStrategy;
  }

  public static LadderGenerator with(RowGeneratorStrategy rowGeneratorStrategy) {
    return new LadderGenerator(rowGeneratorStrategy);
  }

  public List<Row> generateRows(int numOfColumn, int height) {
    List<Row> rows = new ArrayList<>();
    int lenOfRow = numOfColumn - 1;
    for (int i=0; i<height; i++) {
      Row row = rowGeneratorStrategy.generateRow(lenOfRow);
      rows.add(row);
    }
    return rows;
  }

  public Ladder generateLadder(int numOfColumn, int height) {
    return Ladder.with(generateRows(numOfColumn, height));
  }

  public RowGeneratorStrategy getRowGeneratorStrategy() {
    return rowGeneratorStrategy;
  }
}
