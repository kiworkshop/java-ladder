package controller.dto;

import domain.ladder.Height;
import domain.result.Result;
import domain.user.User;

import java.util.List;

public class LadderInputDto {

    private List<User> users;
    private List<Result> results;
    private Height height;

    public LadderInputDto(List<User> users, List<Result> results, Height height) {
        this.users = users;
        this.results = results;
        this.height = height;
    }

    public int getNumberOfSteps() {
        return users.size() - 1;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Result> getResults() {
        return results;
    }
}
