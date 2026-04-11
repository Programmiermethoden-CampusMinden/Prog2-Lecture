package junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Beispiel-Test (parametrisiert, Variante @ValueSource) mit JUnit 5
 */

public class TestValueSource {
    @ParameterizedTest
    @ValueSource(strings = { "wuppie", "fluppie", "foo" })
    @Tag("junit5")
    void testWuppie(String candidate) {
        assertTrue(candidate.equals("wuppie"));
    }
}
