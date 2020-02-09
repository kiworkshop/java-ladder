package controller;

import domain.factory.RandomRowFactory;
import domain.factory.RowFactory;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.Result;
import domain.result.Results;
import domain.user.Users;
import service.LadderService;
import view.input.GameInputScanner;
import view.output.GameOutputView;

public class LadderController {

    private static final RowFactory ROW_FACTORY = new RandomRowFactory();

    private LadderService ladderService = new LadderService();

    public void play() {
        Users users = ladderService.makeUsers(GameInputScanner.getUserNames());
        Results results = ladderService.makeResults(GameInputScanner.getResults());
        ladderService.validates(users, results);
        Height height = ladderService.makeHeight(GameInputScanner.getHeight());
        Ladder ladder = new Ladder(users.size() - 1, height, ROW_FACTORY);
        printLadder(users, ladder, results);
        showResult(users, ladder, results);
    }

    private void printLadder(Users users, Ladder ladder, Results results) {
        GameOutputView.printUsers(users);
        GameOutputView.printLadder(ladder);
        GameOutputView.printResults(results);
    }

    private void showResult(Users users, Ladder ladder, Results results) {
        while (true) {
            String userName = GameInputScanner.getUserNameForResult();
            if ("all".equals(userName)) {
                break;
            }
            int index = users.findIndexBy(userName);
            int resultIndex = ladder.getResultIndexFrom(index);
            Result result = results.get(resultIndex);
            GameOutputView.printResult(result);
        }
        GameOutputView.printAllResult(users, ladder, results);
    }

}
