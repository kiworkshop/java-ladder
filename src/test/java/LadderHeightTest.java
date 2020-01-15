import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {
  @Test
  void of_ValidInput_ValidOutput() {
    // given
    int height = 1;
    // when
    LadderHeight ladderHeight = LadderHeight.of(height);
    // then
    assertThat(ladderHeight.getHeight()).isEqualTo(height);
  }

  @Test
  void of_InvalidInput_ThrowException() {
    // given
    int height = 0;
    // then
    assertThatThrownBy(() -> LadderHeight.of(height)).isInstanceOf(IllegalArgumentException.class);
  }
}
