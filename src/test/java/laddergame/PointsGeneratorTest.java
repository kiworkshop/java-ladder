package laddergame;

import laddergame.domain.LadderGameInput;
import laddergame.domain.LadderGamePlayers;
import laddergame.domain.Point;
import laddergame.domain.PointsGenerator;
import laddergame.view.InputScanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsGeneratorTest {

    private static final String DELIMITER = ",";

    @BeforeAll
    public static void setUp() {
        String playerNamesString= "태식,태식이,태식삼";
        List<String> playerNames = Arrays.asList(playerNamesString.split(DELIMITER));
        LadderGamePlayers.calculatePlayerCount(playerNames);

        String ladderHeightString = "2";
        InputStream inputStream = new ByteArrayInputStream(ladderHeightString.getBytes());
        System.setIn(inputStream);
        LadderGameInput.getLadderHeightFromInputScanner(new InputScanner());
    }

    @Test
    public void testGeneratePoints() {
        // given
        List<Point> expectedPoints = new ArrayList<>();
        expectedPoints.add(new Point(0, 0));
        expectedPoints.add(new Point(0, 1));
        expectedPoints.add(new Point(0, 2));
        expectedPoints.add(new Point(1, 0));
        expectedPoints.add(new Point(1, 1));
        expectedPoints.add(new Point(1, 2));

        // when
        List<Point> points = PointsGenerator.generatePoints();

        // then
        assertThat(points)
                .isNotNull()
                .isEqualTo(expectedPoints);

    }

}