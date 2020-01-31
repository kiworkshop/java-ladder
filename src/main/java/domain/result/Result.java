package domain.result;

public class Result {

    private static final int RESULT_LIMIT_LENGTH = 5;

    private String result;

    public Result(String result) {
        if ( result.length() > RESULT_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.result = result;
    }

    public String getFormattedResult() {
        return String.format("%" + RESULT_LIMIT_LENGTH + "s", result);
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return result;
    }
}
