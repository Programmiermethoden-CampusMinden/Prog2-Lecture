package junit6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumTest {

    @Test
    void returns_sum_of_two_positive_integers() {
        // given
        Sum sum = new Sum();
        int a = 2;
        int b = 3;

        // when
        int result = sum.sum(a, b);

        // then
        assertEquals(5, result);
    }

    @ParameterizedTest(name = "sum({0}, {1}) should be {2}")
    @CsvSource({
        // a, b, expectedSum
        "0,    0,   0",
        "1,    1,   2",
        "2,    3,   5",
        "-1,   1,   0",
        "-5,  -7,  -12"
    })
    void returns_correct_sum_for_various_integer_pairs(int a, int b, int expectedSum) {
        // given
        Sum sum = new Sum();

        // when
        int result = sum.sum(a, b);

        // then
        assertEquals(expectedSum, result);
    }
}
