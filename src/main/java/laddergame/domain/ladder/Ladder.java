package laddergame.domain.ladder;

import laddergame.domain.ladder.Strategy.LadderCreationStrategy;
import laddergame.domain.ladderheight.LadderHeight;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(final List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder with(final Players players, final LadderHeight ladderHeight, LadderCreationStrategy strategy) {
        List<LadderLine> lines = new ArrayList<>();
        int width = players.size();
        int height = ladderHeight.getHeight();

        for (int i = 0; i < height; i++) {
            LadderLine line = LadderLine.with(width, strategy);
            lines.add(line);
        }

        return new Ladder(lines);
    }
}
