package domain.user;

public class User {

    private static final int NAME_LIMIT_LENGTH = 5;

    private String name;

    public User(String name) {
        if ( name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
