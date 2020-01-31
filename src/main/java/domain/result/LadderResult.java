package domain.result;

import domain.user.User;

import java.util.Map;

public class LadderResult {

    Map<User, Result> ladderResult;

    public LadderResult(Map<User, Result> ladderResult) {
        this.ladderResult = ladderResult;
    }

    @Override
    public String toString() {
        return "결과 : " + ladderResult.toString();
    }

}
