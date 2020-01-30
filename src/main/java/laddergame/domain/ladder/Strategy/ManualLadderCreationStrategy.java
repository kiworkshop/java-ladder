package laddergame.domain.ladder.Strategy;

public class ManualLadderCreationStrategy implements LadderCreationStrategy {

    @Override
    public boolean isConnectable() {
        return true;
    }
}
