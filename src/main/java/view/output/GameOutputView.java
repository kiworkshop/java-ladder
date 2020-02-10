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
        System.out.println();
    }

    public static void printResult(Result result) {
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(Users users, Ladder ladder, Results results) {
        System.out.println();
        for (int i = 0; i < users.size(); i++) {
            int resultIndex = ladder.getResultIndexFrom(i);
            Result result = results.get(resultIndex);
            System.out.println(users.get(i) + " : " + result);
        }
    }
}
