package view.output;

import domain.ladder.Ladder;
import domain.result.Result;
import domain.result.Results;
import domain.user.Users;

public class GameOutputView {

    public static void printUsers(Users users) {
        System.out.println(users);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printResults(Results results) {
        System.out.println(results);
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }
}
