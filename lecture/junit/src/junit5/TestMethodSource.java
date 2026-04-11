package junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Beispiel-Test (parametrisiert, Variante @MethodSource) mit JUnit 5
 */

public class TestMethodSource {
    public static int[][] values() {
        return new int[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 2, 2, 5 } };
    }

    @ParameterizedTest
    @MethodSource("values")
    @Tag("junit5")
    void testSum(int[] data) {
        assertEquals(data[0] + data[1], data[2]);
    }
}
