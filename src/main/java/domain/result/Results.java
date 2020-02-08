package domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public int size() {
        return results.size();
    }

    public Result get(int resultIndex) {
        return results.get(resultIndex);
    }

    @Override
    public String toString() {
        List<String> resultList = results.stream().map(Result::getFormattedResult).collect(Collectors.toList());
        return String.join(" ", resultList);
    }
}
