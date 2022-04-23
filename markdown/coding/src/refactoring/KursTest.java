package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KursTest {
    @Test
    public void testKurs() {
        Kurs k = new Kurs("Test", 42);

        assertEquals("Test", k.descr);
        assertEquals(42, k.cps);
    }
}
