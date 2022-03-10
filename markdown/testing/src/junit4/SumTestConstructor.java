package junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Beispiel-Test (parametrisiert, Variante Konstruktor) mit JUnit 4
 */

@RunWith(Parameterized.class)
public class SumTestConstructor {

    private final int s1;
    private final int s2;
    private final int erg;

    public SumTestConstructor(int p1, int p2, int p3) {
        s1 = p1;
        s2 = p2;
        erg = p3;
    }

    @Parameters
    public static Collection<Object[]> values() {
        return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 2, 2, 5 } });
    }

    @Test
    public void testSum() {
        Sum s = new Sum();
        assertEquals(s.sum(s1, s2), erg);
    }
}
