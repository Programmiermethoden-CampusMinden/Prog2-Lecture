package junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Beispiel-Test mit JUnit 5
 */

class Test5 {
    @Test
    @Tag("junit5")
    void testSum() {
        assertEquals(6, 2 + 4);
    }
}
