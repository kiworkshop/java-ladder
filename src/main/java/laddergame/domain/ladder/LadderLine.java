package laddergame.domain.ladder;

import java.util.Objects;

public class LadderLine {

    private Point leftPoint;
    private Point rightPoint;
    public boolean exists = false;

    public LadderLine(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine ladderLine = (LadderLine) o;
        return exists == ladderLine.exists &&
                Objects.equals(leftPoint, ladderLine.leftPoint) &&
                Objects.equals(rightPoint, ladderLine.rightPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPoint, rightPoint, exists);
    }

    @Override
    public String toString() {
        return "laddergame.domain.ladder.Line{" +
                "leftPoint=" + leftPoint +
                ", rightPoint=" + rightPoint +
                ", exists=" + exists +
                '}';
    }
}
