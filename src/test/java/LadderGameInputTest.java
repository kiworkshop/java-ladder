import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameInputTest {

    private static final String DELIMITER = ",";

    @Test
    public void testGetSingleNameFromInputScanner() {
        // given
        String inputString = "태식";
        setInputStream(inputString);

        LadderGameInput input = new LadderGameInput();

        List<String> playerName = Arrays.asList(inputString.split(DELIMITER));

        // when
        input.getPlayerNamesFromInputScanner(input.generateInputScanner());

        // then
        assertThat(input.getPlayerNames())
                .isNotNull()
                .isEqualTo(playerName);
    }

    @Test
    public void testGetMultipleNamesFromInputScanner() {
        // given
        String inputString = "태식,태식이,태식삼";
        setInputStream(inputString);

        LadderGameInput input = new LadderGameInput();

        List<String> playerNames = Arrays.asList(inputString.split(DELIMITER));

        // when
        input.getPlayerNamesFromInputScanner(input.generateInputScanner());

        // then
        assertThat(input.getPlayerNames())
                .isNotNull()
                .isEqualTo(playerNames);
    }

    @Test
    public void testGetLadderHeightFromInputScanner() {
        // given
        String inputString = "2";
        setInputStream(inputString);

        LadderGameInput input = new LadderGameInput();

        // when
        input.getLadderHeightFromInputScanner(input.generateInputScanner());

        // then
        assertThat(input.getLadderHeight())
                .isNotNull()
                .isEqualTo(2);
    }

    public void setInputStream(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
    }

}
