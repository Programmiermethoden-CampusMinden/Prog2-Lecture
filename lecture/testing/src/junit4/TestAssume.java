package junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

public class TestAssume {
    @Test
    public void testStudi() {
        Studi s = new Studi();
        int cps = 2;
        // cps = -5;

        // assumeTrue(cps > 0);

        s.addToCredits(cps);
        assertEquals(cps, s.getCredits());
    }
}
