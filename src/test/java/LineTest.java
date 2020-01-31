import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void AssureBarsNotContinuous1() {
        //when
        Line lineNotContinus = new Line(Arrays.asList(Bar.of(true), Bar.of(false)));
        Line lineiContinus = new Line(Arrays.asList(Bar.of(true), Bar.of(true)));
        //then
        assertThat(twoBarsNotContinuous(lineNotContinus)).isTrue();
        assertThat(twoBarsNotContinuous(lineiContinus)).isFalse();
    }

    @Test
    void AssureBarsNotContinuous2() {
        //when
        Line line = new Line(100);
        //then
        assertThat(twoBarsNotContinuous(line)).isTrue();
    }
    @Test
    private boolean twoBarsNotContinuous(Line line) {
        List<Bar> bars = line.getBars();
        boolean lastBarExists = false;
        for (Bar bar : bars) {
            if (lastBarExists && bar.isExists()) {
                return false;
            }
            lastBarExists = bar.isExists();
        }
        return true;
    }
    @Test
    void testPlayTrueBarGame() {
        //given
        Line testLine = new Line(Arrays.asList(Bar.of(true), Bar.of(false)));
        List<Person> people = TheMiddleLadderApplication.makePeople("a,b");
        Bar testTrueBar = Bar.of(true);
        int barIndex = 0;

        //when
        testLine.playBarGame(barIndex, testTrueBar, people );

        //then
        assertThat(people.get(0).getPosition()).isEqualTo(1);
        assertThat(people.get(1).getPosition()).isEqualTo(0);
    }
    @Test
    void testPlayFalseBarGame() {
        //given
        Line testLine = new Line(Arrays.asList(Bar.of(false), Bar.of(true)));
        List<Person> people = TheMiddleLadderApplication.makePeople("a,b");
        Bar testTrueBar = Bar.of(false);
        int barIndex = 0;

        //when
        testLine.playBarGame(barIndex, testTrueBar, people );

        //then
        assertThat(people.get(0).getPosition()).isEqualTo(0);
        assertThat(people.get(1).getPosition()).isEqualTo(1);
    }

    @Test
    void testPlayLineGame() {
        //given
        Line testLine = new Line(Arrays.asList(Bar.of(true), Bar.of(false)));
        List<Person> people = TheMiddleLadderApplication.makePeople("a,b,c");

        //when
        people = testLine.playLineGame(people);

        //then
        assertThat(people   //TODO people에서 이름으로 객체를 찾는 방법을 궁색하게도 이것 밖에 떠올리지 못했다...
                .stream()
                .filter(person -> person
                        .getName()
                        .equals("a"))
                .collect(Collectors.toList())
                .get(0)
                .getPosition())
                .isEqualTo(1);
        assertThat(people
                .stream()
                .filter(person -> person
                        .getName()
                        .equals("b"))
                .collect(Collectors.toList())
                .get(0)
                .getPosition())
                .isEqualTo(0);
        assertThat(people
                .stream()
                .filter(person -> person
                        .getName()
                        .equals("c"))
                .collect(Collectors.toList())
                .get(0)
                .getPosition())
                .isEqualTo(2);
    }
}