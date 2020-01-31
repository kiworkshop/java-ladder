package domain.ladder;

public class Height {

    private static final int MINIMUM_HEIGHT_THRESHOLD = 0;

    private int height;

    public static Height from(int height) {
        if (height <= MINIMUM_HEIGHT_THRESHOLD) {
            throw new IllegalArgumentException();
        }
        return new Height(height);
    }

    private Height(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
