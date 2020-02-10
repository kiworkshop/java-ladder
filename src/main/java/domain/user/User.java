package domain.user;

import java.util.Objects;

public class User {

    private static final int NAME_LIMIT_LENGTH = 5;

    private String name;

    private User(String name) {
        this.name = name;
    }

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

    public String getFormattedName() {
        return String.format("%" + NAME_LIMIT_LENGTH + "s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
