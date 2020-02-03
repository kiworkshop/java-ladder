package game.dto;

import domain.ladder.Height;
import domain.result.Result;
import domain.user.User;

import java.util.List;

import static domain.user.UserTest.getUsersFixture;
import static domain.result.ResultTest.getResultsFixture;

public class LadderDataTest {

    public static LadderInputDto getLadderDataFixture() {
        List<User> users = getUsersFixture();
        List<Result> results = getResultsFixture();
        Height height = Height.from(5);
        LadderInputDto ladderInputDto = new LadderInputDto(users, results, height);
        return ladderInputDto;
    }

}