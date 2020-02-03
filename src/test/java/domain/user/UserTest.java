package domain.user;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private static final String JAEJU_NAME = "장재주";
    private static final String OVER_LIMITATION_NAME = "장재주장장장";
    private static final String EMPTY_STRING = "";

    @Test
    void testUserConstructor() {
        User user = User.from(JAEJU_NAME);
        assertThat(user).hasFieldOrPropertyWithValue("name", JAEJU_NAME);

        assertThatThrownBy(() -> User.from(OVER_LIMITATION_NAME))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> User.from(EMPTY_STRING))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static List<User> getUsersFixture() {
        List<User> users = new ArrayList<>();
        users.add(getJAEJUFixture());
        users.add(getDEOCKFixture());
        users.add(getKWANGFixture());
        users.add(getLUKEFixture());
        return users;
    }

    public static User getJAEJUFixture() {
        return User.from(JAEJU_NAME);
    }

    public static User getDEOCKFixture() {
        return User.from("deock");
    }

    public static User getKWANGFixture() {
        return User.from("kwang");
    }

    public static User getLUKEFixture() {
        return User.from("luke");
    }
}
