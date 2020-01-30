package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.ManualLadderCreationStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void 첫번째_포인트의_leftConnection은_false() {
        //given
        Point firstPoint = Point.generateFirstPoint(new ManualLadderCreationStrategy());
        Point expected = Point.RIGHT;

        //then
        assertThat(firstPoint).isEqualTo(expected);
    }

    @Test
    void 마지막_포인트의_rightConnection은_false() {
        //given
        Point LastPoint = Point.generateLastPoint(new ManualLadderCreationStrategy());
        Point expected = Point.LEFT;

        //then
        assertThat(LastPoint).isEqualTo(expected);
    }

    @Test
    void 다음_포인트의_connection이_잘_결정되는지_테스트() {
        //given
        Point nextOfLeft = Point.LEFT.decideNextPoint(new ManualLadderCreationStrategy());
        Point nextOfRight = Point.RIGHT.decideNextPoint(new ManualLadderCreationStrategy());
        Point nextOfNone = Point.NONE.decideNextPoint(new ManualLadderCreationStrategy());

        //then
        assertThat(nextOfLeft).isEqualTo(Point.RIGHT);
        assertThat(nextOfRight).isEqualTo(Point.LEFT);
        assertThat(nextOfNone).isEqualTo(Point.RIGHT);
    }
}