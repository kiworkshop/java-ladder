import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void constructorTest(){
        LadderGame ladderGame = new LadderGame();
        assertThat(ladderGame.getLadderHeight())
                .isNotNull()
                .isGreaterThan(0);
        assertThat(ladderGame.getUsers())
                .isNotNull()
                .isNotEmpty();
    }
}