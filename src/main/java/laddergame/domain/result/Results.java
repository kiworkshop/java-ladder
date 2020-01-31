package laddergame.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static List<Result> createResultList(String[] resultNames) {
        return Arrays.stream(resultNames)
                .map(String::trim)
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
