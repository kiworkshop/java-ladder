package laddergame.domain.result;

public class Result {

    public static final int RESULT_NAME_MAX_LENGTH = 5;

    private final String name;

    public Result(final String name) {
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    private boolean isLongerThanMaxLength(final String name) {
        return name.length() > RESULT_NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
