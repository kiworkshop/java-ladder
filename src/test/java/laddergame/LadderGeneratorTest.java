package laddergame;

import laddergame.domain.*;
import laddergame.view.InputScanner;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    private static final String DELIMITER = ",";

    @Test
    public void testGenerate2x1Ladder() {
        // given
        Point leftPoint = new Point(0, 0);
        Point rightPoint = new Point(0, 1);

        Line line = new Line(leftPoint, rightPoint);

        Ladder expectedLadder = new Ladder();
        expectedLadder.lines.add(line);

        String playerNamesString= "태식,태식이";
        List<String> playerNames = Arrays.asList(playerNamesString.split(DELIMITER));
        LadderGamePlayers.calculatePlayerCount(playerNames);

        String ladderHeightString = "1";
        InputStream inputStream = new ByteArrayInputStream(ladderHeightString.getBytes());
        System.setIn(inputStream);
        LadderGameInput.getLadderHeightFromInputScanner(new InputScanner());

        // when
        Ladder TwoByOneLadder = LadderGenerator.generateLadder();

        // then
        assertThat(TwoByOneLadder)
                .isNotNull()
                .isEqualTo(expectedLadder);
    }
    
}
