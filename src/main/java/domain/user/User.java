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

    public String getFormattedName() {
        return String.format("%" + NAME_LIMIT_LENGTH + "s", name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
