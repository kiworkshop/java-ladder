package laddergame;

import laddergame.domain.*;
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
        List<Line> expectedLines = new ArrayList<>();
        expectedLines.add(new Line(new Point(0,0), new Point(0,1)));
        expectedLines.add(new Line(new Point(0,1), new Point(0,2)));
        expectedLines.add(new Line(new Point(1,0), new Point(1,1)));
        expectedLines.add(new Line(new Point(1,1), new Point(1,2)));

        // when
        List<Line> lines = LinesGenerator.generateLines();

        // then
        assertThat(lines)
                .isNotNull()
                .isEqualTo(expectedLines);
    }

}