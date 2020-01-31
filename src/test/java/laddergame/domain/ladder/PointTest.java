package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.ManualLadderCreationStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void generateFirstPoint() {
        //given
        Point firstPoint = Point.generateFirstPoint(new ManualLadderCreationStrategy());
        Point expected = Point.RIGHT;

        //then
        assertThat(firstPoint).isEqualTo(expected);
    }

    @Test
    void generateLastPoint() {
        //given
        Point LastPoint = Point.generateLastPoint(Point.RIGHT);
        Point expected = Point.LEFT;

        //then
        assertThat(LastPoint).isEqualTo(expected);
    }

    @Test
    void decideNextPoint() {
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