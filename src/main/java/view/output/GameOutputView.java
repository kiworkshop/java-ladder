package view.output;

import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Result;

public class GameOutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.println(ladderResult);
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }
}
