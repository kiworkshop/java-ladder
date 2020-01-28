import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
  @Test
  void with_ValidInput_ValidOutput() {
    // given
    String prizeName = "testPrizeName";
    int position = 0;
    // then
    assertThat(Prize.with(prizeName, position).getPrizeName()).isEqualTo(prizeName);
    assertThat(Prize.with(prizeName, position).getPosition()).isEqualTo(position);
  }

}