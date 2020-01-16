import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
  @Test
  void startWith_ValidInput_ValidOutput() {
    // when
    Line line = Line.startWith(0);
    // then
    assertThat(line.getStartPosition()).isEqualTo(0);
    assertThat(line.getEndPosition()).isEqualTo(1);
  }
}
