package laddergame;

import laddergame.domain.*;
import laddergame.domain.ladder.LadderLine;
import laddergame.domain.ladder.LinesGenerator;
import laddergame.domain.ladder.Point;
import laddergame.domain.player.Players;
import laddergame.view.InputScanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesGeneratorTest {

    private static final String DELIMITER = ",";

    @BeforeAll
    public static void setUp() {
        String playerNamesString= "태식,태식이,태식삼";
        List<String> playerNames = Arrays.asList(playerNamesString.split(DELIMITER));
        Players.calculatePlayerCount(playerNames);

        String ladderHeightString = "2";
        InputStream inputStream = new ByteArrayInputStream(ladderHeightString.getBytes());
        System.setIn(inputStream);
        LadderGameInput.getLadderHeightFromInputScanner(new InputScanner());
    }

    @Test
    public void testGenerateLines() {
        // given
        List<LadderLine> expectedLadderLines = new ArrayList<>();
        expectedLadderLines.add(new LadderLine(new Point(0,0), new Point(0,1)));
        expectedLadderLines.add(new LadderLine(new Point(0,1), new Point(0,2)));
        expectedLadderLines.add(new LadderLine(new Point(1,0), new Point(1,1)));
        expectedLadderLines.add(new LadderLine(new Point(1,1), new Point(1,2)));

        // when
        List<LadderLine> ladderLines = LinesGenerator.generateLines();

        // then
        assertThat(ladderLines)
                .isNotNull()
                .isEqualTo(expectedLadderLines);
    }

}