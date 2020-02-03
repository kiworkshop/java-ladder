package domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    private static final String RESULT = "50000";
    private static final String RESULT_OVER_LENGTH_LIMIT = "500000";
    private static final String EMPTY_RESUlT = "";

    public static List<Result> getResultsFixture() {
        List<Result> results = new ArrayList<>();
        results.add(Result.from("50000"));
        results.add(Result.from("10000"));
        results.add(Result.from("20000"));
        results.add(Result.from("500"));
        return results;
    }

    @Test
    @DisplayName("Result 클래스의 생성자를 테스트")
    void testResultConstructor() {
        Result result = Result.from(RESULT);

        assertThatThrownBy(() -> Result.from(RESULT_OVER_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Result.from(EMPTY_RESUlT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}