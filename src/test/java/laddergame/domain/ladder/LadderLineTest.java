package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.ManualLadderCreationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        List<Point> points = new ArrayList<>();
        points.add(Point.RIGHT);
        points.add(Point.LEFT);
        points.add(Point.RIGHT);
        points.add(Point.LEFT);
        points.add(Point.NONE);

        ladderLine = new LadderLine(points);
    }

    @Test
    void with() {
        //given
        LadderLine actualLadderLine = LadderLine.with(5, new ManualLadderCreationStrategy());

        //then
        assertThat(actualLadderLine).isEqualTo(ladderLine);
    }

    @Test
    void size() {
        // given
        LadderLine actualLadderLine = LadderLine.with(5, new ManualLadderCreationStrategy());

        // then
        assertThat(actualLadderLine.size()).isEqualTo(ladderLine.size());
    }
}