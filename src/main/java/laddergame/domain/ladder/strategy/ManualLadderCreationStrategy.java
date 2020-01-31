package laddergame.domain.ladder.strategy;

public class ManualLadderCreationStrategy implements LadderCreationStrategy {

    @Override
    public boolean isConnectable() {
        return true;
    }
}
