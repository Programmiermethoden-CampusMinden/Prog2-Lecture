package junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestAssume {
    @Test
    public void testSum() {
        Sum s = new Sum();
        int s1 = 2;
        int s2 = -3;
        int erg = 5;

        assumeTrue(s2 > 0);

        fail();
        assertEquals(erg, s.sum(s1, s2));
    }
}
