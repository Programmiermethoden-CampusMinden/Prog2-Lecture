package junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
