import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGamePlayersTest {

    private static final String DELIMITER = ",";

    @Test
    public void testGetPlayerCount() {
        // given
        String inputString= "태식,태식이,태식삼";
        List<String> playerNames = Arrays.asList(inputString.split(DELIMITER));

        LadderGamePlayers.calculatePlayerCount(playerNames);

        // when
        int playerCount = LadderGamePlayers.getPlayerCount();

        // then
        assertThat(playerCount)
                .isNotNull()
                .isEqualTo(3);

    }

}
