package domain.user;

public class User {

    private static final int NAME_LIMIT_LENGTH = 5;

    private String name;

    public static User from(String name) {
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
        return new User(name);
    }

    private User(String name) {
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
