package laddergame.domain;

import java.util.Objects;

public class Line {

    private Point leftPoint;
    private Point rightPoint;
    public boolean exists = false;

    public Line(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return exists == line.exists &&
                Objects.equals(leftPoint, line.leftPoint) &&
                Objects.equals(rightPoint, line.rightPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPoint, rightPoint, exists);
    }

    @Override
    public String toString() {
        return "laddergame.domain.Line{" +
                "leftPoint=" + leftPoint +
                ", rightPoint=" + rightPoint +
                ", exists=" + exists +
                '}';
    }
}
