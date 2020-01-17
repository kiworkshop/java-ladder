import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class InputValidatorTest {

    private static final String DELIMITER = ",";
    private static final String ERROR_MESSAGE_NAME_LENGTH_EXCEEDED = "이름이 5자를 초과할 수 없습니다.";

    @Test
    public void testValidatePlayerNameIsSmallerThanCriterion() {
        // given
        String inputString = "태식,태식이,이름길이초과";
        List<String> playerNames = Arrays.asList(inputString.split(DELIMITER));

        // when
        Throwable thrown = catchThrowable(() -> { InputValidator.validatePlayerNames(playerNames);});

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NAME_LENGTH_EXCEEDED);
    }

}