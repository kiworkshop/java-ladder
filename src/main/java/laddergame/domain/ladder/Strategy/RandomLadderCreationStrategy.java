package laddergame.domain.ladder.Strategy;

import java.util.Random;

public class RandomLadderCreationStrategy implements LadderCreationStrategy{

    @Override
    public boolean isConnectable() {
        return new Random().nextBoolean();
    }
}
