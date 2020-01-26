package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.InputView;

public class LadderGame {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView());
        ladderGameController.run();
    }
}
