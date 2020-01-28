import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}