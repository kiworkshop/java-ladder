import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGamePlayersTest {

    private static final String DELIMITER = ",";

    @Test
    public void testGetPlayerCount() {
        // given
        String inputString= "태식,태식이,태식삼";
        List<String> playerNames = Arrays.asList(inputString.split(DELIMITER));

        // when
        int playerCount = LadderGamePlayers.getPlayerCount(playerNames);

        // then
        assertThat(playerCount)
                .isNotNull()
                .isEqualTo(3);

    }




}
