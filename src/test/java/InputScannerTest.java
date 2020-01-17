import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputScannerTest {

    @Test
    public void testGetPlayerNames() {
        // given
        String inputString = "태식\r\n";
        setInputStream(inputString);
        InputScanner playerNamesScanner = new InputScanner();

        // when
        String playerNames = playerNamesScanner.getPlayerNamesFromUser();

        // then
        assertThat(playerNames)
                .isNotNull()
                .isEqualTo("태식");
    }

    @Test
    public void testGetLadderHeight() {
        // given
        String inputString = "2\r\n";
        setInputStream(inputString);
        InputScanner ladderHeightScanner = new InputScanner();

        // when
        int ladderHeight = ladderHeightScanner.getLadderHeightFromUser();

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
