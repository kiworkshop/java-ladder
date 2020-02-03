package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class HeightTest {

    private static final int FIVE_LEVEL_OF_HEIGHT = 5;
    private static final int MINIMUM_HEIGHT_THRESHOLD = 0;

    public static Height getFiveLevelOfHeight() {
        Height height = Height.from(FIVE_LEVEL_OF_HEIGHT);
        return height;
    }

    @Test
    @DisplayName("Height 클래스가 생성되는 시점에 잘 생성되는 것과 생성되지 않는 경우 테스트")
    void testHeight() {
        Height height = Height.from(FIVE_LEVEL_OF_HEIGHT);

        assertThatThrownBy(() -> Height.from(MINIMUM_HEIGHT_THRESHOLD))
                .isInstanceOf(IllegalArgumentException.class);
    }
}