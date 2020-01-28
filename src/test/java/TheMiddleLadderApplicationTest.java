import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheMiddleLadderApplicationTest {
    @Test
    void testSplitNames() {
        String[] targetArray = {"a", "b", "c"};
        String inputString = "a,b,c";
        String[] splitedNames = TheMiddleLadderApplication.splitNames(inputString, ",");

        assertThat(splitedNames).isEqualTo(targetArray);
    }

}