import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Integer> linePositions = new ArrayList<>();

    public Line(int countOfPerson) {
        int maxLinePos = countOfPerson - 1;
        Random rand = new Random();
        for(int i = 0 ; i < maxLinePos ; i++){
            if(rand.nextBoolean()) {
                linePositions.add(i++);
            }
        }
    }

    public List<Integer> getLinePositions() {
        return linePositions;
    }

}
