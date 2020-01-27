package laddergame.domain.ladderheight;

public class LadderHeight {

    private static final int LADDER_HEIGHT_MIN_LENGTH = 1;

    private final int height;

    public LadderHeight(int height) {
        if (isLongerThanMinLength(height)) {
            throw new IllegalArgumentException();
        }

        this.height = height;
    }

    private boolean isLongerThanMinLength(int height) {
        return height >= LADDER_HEIGHT_MIN_LENGTH;
    }

    public int getHeight() {
        return height;
    }
}
