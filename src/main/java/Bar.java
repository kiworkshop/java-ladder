public class Bar {
    public static final String BAR_EXIST = "-----";
    public static final String BAR_NOT_EXIST = "     ";
    public static final double BAR_EXIST_PERCENTAGE = 0.5;

    private boolean exists;

    private Bar(boolean exists) {
        this.exists = exists;
    }

    public static Bar ofRandom() {
        return new Bar(Math.random() > BAR_EXIST_PERCENTAGE);
    }

    public static Bar of(boolean exists) {
        return new Bar(exists);
    }

    public boolean isExists() {
        return exists;
    }

    public void disconnect() {
        this.exists = false;
    }

    @Override
    public String toString() {
        if (isExists()) {
            return BAR_EXIST;
        }
        return BAR_NOT_EXIST;
    }
}
