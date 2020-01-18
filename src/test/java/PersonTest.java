import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    @Test
    void testValidateName() {
        assertThatThrownBy(() -> {
            Person person = new Person("abcdef");
        });
    }

}