package junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Beispiel-Test (parametrisiert, Variante @Parameter-Annotation) mit JUnit 4
 */

@RunWith(Parameterized.class)
public class SumTestParameters {

    @Parameter(0)
    public int s1;

    @Parameter(1)
    public int s2;

    @Parameter(2)
    public int erg;

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
