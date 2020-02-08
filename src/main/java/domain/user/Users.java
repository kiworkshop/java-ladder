package domain.user;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int findIndexBy(String userName) {
        User user = User.from(userName);
        return users.indexOf(user);
    }

    public int size() {
        return users.size();
    }

    @Override
    public String toString() {
        List<String> userNames = users.stream().map(User::getFormattedName).collect(Collectors.toList());
        return String.join(" ", userNames);
    }
}
