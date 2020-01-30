package domain.user;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private static final String JAEJU_NAME = "장재주";
    private static final String OVER_LIMITATION_NAME = "장재주장장장";

    @Test
    void testUser() {
        User user = new User(JAEJU_NAME);
        assertThat(user).hasFieldOrPropertyWithValue("name", JAEJU_NAME);

        assertThatThrownBy(() -> new User(OVER_LIMITATION_NAME))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
