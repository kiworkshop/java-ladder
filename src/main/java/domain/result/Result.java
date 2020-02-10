package domain.result;

public class Result {

    private static final int RESULT_LIMIT_LENGTH = 5;

    private String result;

    private Result(String result) {
        this.result = result;
    }

    public static Result from(String result) {
        result = result.trim();
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (result.length() > RESULT_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
        return new Result(result);
    }

    public String getFormattedResult() {
        return String.format("%" + RESULT_LIMIT_LENGTH + "s", result);
    }

    @Override
    public String toString() {
        return result;
    }
}
