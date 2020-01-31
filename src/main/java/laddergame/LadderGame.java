package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new OutputView());
        ladderGameController.run();
    }
}
