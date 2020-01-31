public class GameResult {
    public static final int NAME_LIMIT = 5;
    public static final String MESSAGE_NAME_LIMIT_EXCEPTION = "5글자 이상 이름을 짓는 것은 불가능합니다.";
    private String name;
    private int position;

    public GameResult(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(MESSAGE_NAME_LIMIT_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }
}
