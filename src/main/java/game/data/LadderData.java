package game.data;

import domain.ladder.Height;
import domain.result.Result;
import domain.user.User;

import java.util.List;

public class LadderData {

    private List<User> users;
    private List<Result> results;
    private Height height;

    public LadderData(List<User> users, List<Result> results, Height height) {
        this.users = users;
        this.results = results;
        this.height = height;
    }

    public int getUserSize() {
        return users.size();
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
