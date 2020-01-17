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

        List<String> expectedPlayerName = Arrays.asList(inputString.split(DELIMITER));

        // when
        List<String> playerName = LadderGameInput.getPlayerNamesFromInputScanner(new InputScanner());

        // then
        assertThat(playerName)
                .isNotNull()
                .isEqualTo(expectedPlayerName);
    }

    @Test
    public void testGetMultipleNamesFromInputScanner() {
        // given
        String inputString = "태식,태식이,태식삼";
        setInputStream(inputString);

        List<String> expectedPlayerNames = Arrays.asList(inputString.split(DELIMITER));

        // when
        List<String> playerNames = LadderGameInput.getPlayerNamesFromInputScanner(new InputScanner());

        // then
        assertThat(playerNames)
                .isNotNull()
                .isEqualTo(expectedPlayerNames);
    }

    @Test
    public void testGetLadderHeightFromInputScanner() {
        // given
        String inputString = "2";
        setInputStream(inputString);

        // when
        int ladderHeight = LadderGameInput.getLadderHeightFromInputScanner(new InputScanner());

        // then
        assertThat(ladderHeight)
                .isNotNull()
                .isEqualTo(2);
    }

    public void setInputStream(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
    }

}
