package game.dto;

import domain.ladder.Height;
import domain.result.Result;
import domain.user.User;

import java.util.List;

import static domain.ladder.HeightTest.getFiveLevelOfHeightFixture;
import static domain.result.ResultTest.getResultsFixture;
import static domain.user.UserTest.getUsersFixture;

public class LadderInputDtoTest {

    public static LadderInputDto getLadderDataFixture() {
        List<User> users = getUsersFixture();
        List<Result> results = getResultsFixture();
        Height height = getFiveLevelOfHeightFixture();
        LadderInputDto ladderInputDto = new LadderInputDto(users, results, height);
        return ladderInputDto;
    }

}