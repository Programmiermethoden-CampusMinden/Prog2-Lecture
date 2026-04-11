package junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Beispiel-Test mit JUnit 4
 */

public class Test4 {
    @Test
    public void testSum() {
        Sum s = new Sum();
        assertEquals(6, s.sum(2, 4));
    }
}
